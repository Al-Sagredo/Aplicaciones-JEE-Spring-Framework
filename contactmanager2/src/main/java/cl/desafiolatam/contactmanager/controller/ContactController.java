package cl.desafiolatam.contactmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import cl.desafiolatam.contactmanager.service.ContactService;

@Controller
@RequestMapping(value = "/contactManager")
public class ContactController {

	@Autowired
	private ContactService contactoServicio;
	private Contacto contacto;
	private List<Contacto> listaContactos;

	private final static Logger logger = LoggerFactory.getLogger(ContactController.class);

	// la lista se instancia dentro del constructor
	public ContactController() {
		super();
		listaContactos = new ArrayList<Contacto>();
	}


	// este metodo redirecciona a la vista del formulario entregando una instancia
	// del objeto Contacto
	// ademas guarda los contactos en una lista de contactos
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getContactList(ModelMap model) {

		model.addAttribute("listaContactos", contactoServicio.getContactList());
		return "contactManager";
	}

	/*
	 * este metodo recibe los parametros del form a traves del objeto contacto con
	 * sus atributos ya seteados, se los pasa al modelo y llama al metodo
	 * getContactList
	 */
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contacto") Contacto contacto, ModelMap model) {

        contactoServicio.addContact(contacto, listaContactos);
		model.put("listaContactos", listaContactos);
		return "contactManager";

	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public String deleteContact(ModelMap model, @RequestParam("id") int id) {
		contactoServicio.deleteContact(id, listaContactos);
		model.put("listaContactos", listaContactos);
		return "contactManager";

	}
}
