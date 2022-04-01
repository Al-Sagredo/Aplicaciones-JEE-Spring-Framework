package cl.desafiolatam.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.desafiolatam.biblioteca.dao.LibroDao;
import cl.desafiolatam.biblioteca.modelo.Libro;


@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		LibroDao libroDao = context.getBean(LibroDao.class);
		Libro libro = new Libro();
		libro.setAutor("pedro");
		libro.setTitulo("cannabis");
		libro.setAno(2008);
		libro.setDisponible("si");
		libro.setImprenta("casa");
		libroDao.add(libro);
		context.close();*/
	}

}
