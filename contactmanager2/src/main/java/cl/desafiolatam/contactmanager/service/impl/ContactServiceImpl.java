package cl.desafiolatam.contactmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.contactmanager.Contacto;
import cl.desafiolatam.contactmanager.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	
	@Autowired
	private Contacto contacto;// inyeccion del modelo
	private List<Contacto> listaContactos;
	
	
	
	public ContactServiceImpl() {
		super();
		listaContactos = new ArrayList<Contacto>();
		listaContactos.clear();
		}

	public void setContact(Contacto contact) {
		this.contacto = contact;
	}
	
	@Override
	public List<Contacto> getContactList() {
		if(contacto.getId() > 0) {
			listaContactos.add(contacto);
		}
		
		return listaContactos;
	}

	@Override
	public void addContact(Contacto contacto, List<Contacto> lista) {
	
		contacto.setId(lista.size() + 1);
		lista.add(contacto);

	}

	@Override
	public void deleteContact(int id, List<Contacto> lista) {
		lista.removeIf(obj -> obj.getId() == id);

	}
	
	

}
