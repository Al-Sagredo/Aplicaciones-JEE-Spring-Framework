package cl.desafiolatam.contactmanager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.springframework.boot.test.context.SpringBootTest;

import cl.desafiolatam.contactmanager.service.ContactService;
import cl.desafiolatam.contactmanager.service.impl.ContactServiceImpl;

@SpringBootTest
class ContactmanagerApplicationTests {
	
private Contacto contacto;
private ContactService contactoServicio;
	
	@BeforeEach
	public void setUp()throws Exception{
		System.out.println("setUp");
		contacto = new Contacto();
		contactoServicio = new ContactServiceImpl();
	}
	
	
	

}


