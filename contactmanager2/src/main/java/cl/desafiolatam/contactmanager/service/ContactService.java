package cl.desafiolatam.contactmanager.service;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.contactmanager.Contacto;

public interface ContactService {

	List<Contacto> getContactList();

	void deleteContact(int id, List<Contacto> lista);
	void addContact(Contacto contacto, List<Contacto> lista);
}
