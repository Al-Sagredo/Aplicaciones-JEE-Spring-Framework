package cl.desafiolatam.biblioteca.VO;

import java.util.List;

import cl.desafiolatam.biblioteca.modelo.Libro;


public class LibroVO {

	List<Libro> libros;
	String mensaje;
	String codigo;
	
	public LibroVO(List<Libro> libros, String mensaje, String codigo) {
		super();
		this.libros = libros;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	

	public LibroVO() {
		super();
	}


	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "LibroVO [libros=" + libros + ", mensaje=" + mensaje + ", codigo=" + codigo + "]";
	}
	
	
}
