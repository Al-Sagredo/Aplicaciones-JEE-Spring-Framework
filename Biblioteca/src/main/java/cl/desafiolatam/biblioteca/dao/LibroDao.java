package cl.desafiolatam.biblioteca.dao;
import java.util.List;

import cl.desafiolatam.biblioteca.modelo.Libro;

public interface LibroDao {

	public int add(Libro libro);
	public int update(Libro libro);
	public int delete(int id);
	public int disponible(int id);
	List<Libro> findByAutorOrTitulo(String texto);
	Libro findById(int id);
	List<Libro> findAll();

	
}
