package cl.desafiolatam.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.biblioteca.BibliotecaApplication;
import cl.desafiolatam.biblioteca.VO.LibroVO;
import cl.desafiolatam.biblioteca.dao.LibroDao;
import cl.desafiolatam.biblioteca.modelo.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroDao dao;
	LibroVO respuesta;

	static Logger logger = LoggerFactory.getLogger(BibliotecaApplication.class);

	@Override
	public LibroVO findByAutorOrTitulo(String texto) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "101");
		try {
			// Libro libro = dao.findByAutorOrTitulo(texto);
			respuesta.setLibros(dao.findByAutorOrTitulo(texto));
			// respuesta.getLibros().add(libro);
			respuesta.setMensaje(String.format("Se ha encontrado %d registro/s", null != respuesta.getLibros().get(0) ? 1 : 0));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Usuario Service: Error en findByAutorOrTitulo", e);
		}
		return respuesta;
	}

	@Override
	public LibroVO add(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "102");
		try {
			int registrosActualizados = dao.add(libro);
			respuesta.setMensaje(registrosActualizados == 1 ? "Se ha creado el libro correctamente"
					: "No se ha podido crear el libro");
			respuesta.setCodigo(registrosActualizados == 1 ? "0" : "102");
		} catch (Exception e) {
			logger.trace("Usuario Service: Error en add", e);
		}
		return respuesta;
	}

	@Override
	public LibroVO update(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "103");
		System.out.println("vo titulo: " + libro.getTitulo() + " id: " + libro.getId());
		try {
			int registrosActualizados = dao.update(libro);
			respuesta.setMensaje(String.format("Se ha/n actualizado correctamente %d libro/s", registrosActualizados));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Usuario Service: Error en update", e);
		}
		return respuesta;
	}

	@Override
	public LibroVO delete(int id) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "104");

		try {
			int registrosActualizados = dao.delete(id);
			respuesta.setMensaje(String.format("Se ha/n eliminado correctamente a %d libro/s", registrosActualizados));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Usuario Service: Error en delete", e);
		}
		return respuesta;
	}

	@Override
	public LibroVO disponible(int id) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105");
		try {
			int registrosActualizados = dao.disponible(id);
			respuesta.setMensaje(String.format("Se ha/n actualizado correctamente %d libro/s", registrosActualizados));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Usuario Service: Error en update", e);
		}
		return respuesta;
	}

	@Override
	public LibroVO findById(Integer id) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "106");
		try {
			Libro libro = dao.findById(id);
			respuesta.getLibros().add(libro);
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", null != libro ? 1 : 0));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Usuario Service: Error en findById", e);
		}
		return respuesta;
	}

	@Override
	public LibroVO getAllLibros() {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "107");
		try {
			respuesta.setLibros((List<Libro>) dao.findAll());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getLibros().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Usuario Service: Error en getAllUsuarios", e);
		}
		return respuesta;
	}

}
