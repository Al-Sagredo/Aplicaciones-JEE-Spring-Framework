package cl.desafiolatam.biblioteca.service;

import cl.desafiolatam.biblioteca.VO.LibroVO;
import cl.desafiolatam.biblioteca.modelo.Libro;

public interface LibroService {

	

	public LibroVO findByAutorOrTitulo(String texto);
	public LibroVO add(Libro libro);
	public LibroVO update(Libro libro);
	public LibroVO delete(int id);
	public LibroVO disponible(int id);
	public LibroVO findById(Integer id);
	public LibroVO getAllLibros();
	
}
