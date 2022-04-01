package cl.desafiolatam.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.desafiolatam.biblioteca.VO.LibroVO;
import cl.desafiolatam.biblioteca.modelo.Libro;
import cl.desafiolatam.biblioteca.service.LibroService;

@Controller
public class BibliotecaController {

	private static final Logger log = LoggerFactory.getLogger(BibliotecaController.class);
	List<Libro> listaEncontrados = new ArrayList<Libro>();
	
	@Autowired
	private LibroService svc;

	/**
	 * Las solicitudes de la pagina principal
	 */
	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		
		return "home";
	}

	/**
	 * Abre el formulario de edición cargando los datos del usuario
	 */

	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam String idLibro, RedirectAttributes ra) {
		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		try {
			Integer id = (Integer.parseInt(idLibro));// parsea el id
			respuestaServicio = svc.findById(id);
			if(respuestaServicio.getCodigo() != "0") {
				model.addAttribute("mensaje", respuestaServicio.getMensaje());
			}
			model.addAttribute("VO", respuestaServicio.getLibros().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en BibliotecaController editarForm", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		return new ModelAndView("redirect:/home");
	}

	/**
	 * Llama al método del servicio que se encarga de actualizar los datos del
	 * usuario en base de datos
	 */
	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute Libro libro, RedirectAttributes ra) {
		LibroVO respuestaServicio = svc.update(libro);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}

	/**
	 * Abre el formulario de creación de usuarios
	 */
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}

	/**
	 * Llama al método del servicio que se encarga de crear los datos del usuario en
	 * base de datos
	 */
	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Libro libro, RedirectAttributes ra) {
		
		LibroVO respuestaServicio = svc.add(libro);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}

	/**
	 * Llama al método del servicio que se encarga de eliminar los datos del usuario
	 * en base de datos y redirecciona al home.
	 */
	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String id, RedirectAttributes ra) {
		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo eliminar el libro, intente nuevamente.");
		try {
			respuestaServicio = svc.delete(Integer.parseInt(id));
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/home");
		} catch (Exception e) {
			log.error("Error en BbliotecaController eliminar", e);
		}

		return new ModelAndView("redirect:/home");
	}
	@GetMapping("/buscarLibro")
	public ModelAndView buscar(Model model, @RequestParam String texto, RedirectAttributes ra) {
		LibroVO respuestaServicio = new LibroVO();
		
		try {			
			//el metodo del service devuelve un VO
			respuestaServicio = svc.findByAutorOrTitulo(texto);
			
			if(respuestaServicio.getCodigo() != "0") {
				respuestaServicio.setMensaje("No se encontró ningún libro con el texto ingresado");
			}
			//por lo que extraemos solo la lista
			listaEncontrados = respuestaServicio.getLibros();
			//mando el modelo con la lista al jsp
			model.addAttribute("listaLibros", listaEncontrados);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("home");
		}catch(Exception e) {
			log.error("Error en BibliotecaContoller buscar");
		}
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		//ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/cambiarDisp")
	public ModelAndView cambiarDisp(Model model, @RequestParam int id,  RedirectAttributes ra) {
		LibroVO respuestaServicio = new LibroVO();
		try {
			respuestaServicio = svc.disponible(id);
			
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/home");
		}catch(Exception e) {
			log.error("Error en BibliotecaContoller cambiarDisp");
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		return new ModelAndView("redirect:/home");
	}
}
