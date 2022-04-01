package cl.desafiolatam.biblioteca.modelo;

public class Libro {

	Integer id;
	String titulo;
	String autor;
	Integer ano;
	String imprenta;
	String disponible;
	
	public Libro() {
		super();
	}

	public Libro(Integer id, String titulo, String autor, Integer ano, String imprenta, String disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.imprenta = imprenta;
		this.disponible = disponible;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano + ", imprenta=" + imprenta
				+ ", disponible=" + disponible + "]";
	}
	
	
	
}
