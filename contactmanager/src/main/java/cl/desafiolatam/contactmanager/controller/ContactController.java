package cl.desafiolatam.contactmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.desafiolatam.contactmanager.Contacto;

@Controller
public class ContactController {

	private final static Logger logger = LoggerFactory.getLogger(ContactController.class);
	private List<Contacto> listaContactos;
	private int id = 0;
	

	// la lista se instancia dentro del constructor
	public ContactController() {
		super();
		listaContactos = new ArrayList<Contacto>();
	}

	// este metodo redirecciona a la vista del formulario entregando una instancia del objeto Contacto
	//ademas guarda los contactos en una lista de contactos
	@RequestMapping(value = "/contactManager", method = RequestMethod.GET)
	public ModelAndView getContactList(@ModelAttribute("contacto") Contacto contacto, ModelMap model) {
		System.out.println("tamaño lista: " + listaContactos.size());
		
		if(contacto.getNombre() != null) {
			listaContactos.add(contacto);
			model.put("listaContactos", listaContactos);
		}


		return new ModelAndView("contactManager", "contacto", contacto);
	}

	/*este metodo recibe los parametros del form a traves del objeto contacto con sus atributos ya seteados, 
	se los pasa al modelo y llama al metodo getContactList*/
	@RequestMapping(value = "/contactManager/addContact", method = RequestMethod.POST)
	public ModelAndView addContact(@Valid @ModelAttribute("contacto") Contacto contacto, BindingResult result,
			ModelMap model) {
	
	    id++;
	    contacto.setId(id);
		return getContactList(contacto, model);
		
	}

	@RequestMapping(value = "/contactManager/deleteContact", method = RequestMethod.POST)
	public ModelAndView deleteContact(ModelMap model, @ModelAttribute("contacto")Contacto contacto)  {
		listaContactos.removeIf(obj -> obj.getId() == contacto.getId());
		if(listaContactos.size() != 0 ) {
			model.put("listaContactos", listaContactos);
		}
		
		return getContactList(contacto, model);
	
	}
}	


