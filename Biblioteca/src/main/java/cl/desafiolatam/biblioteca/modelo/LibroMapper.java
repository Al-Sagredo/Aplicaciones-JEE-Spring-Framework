package cl.desafiolatam.biblioteca.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LibroMapper implements RowMapper<Libro> {

	@Override
	public Libro mapRow(ResultSet rs, int i) throws SQLException {
		Libro libro = new Libro();
		libro.setId(rs.getInt("id"));
		libro.setAutor(rs.getString("autor"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAno(rs.getInt("ano"));
		libro.setImprenta(rs.getString("imprenta"));
		libro.setDisponible(rs.getString("disponible"));
		return libro;
	}

}
