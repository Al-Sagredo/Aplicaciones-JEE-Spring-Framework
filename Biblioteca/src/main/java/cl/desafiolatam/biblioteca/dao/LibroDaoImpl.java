package cl.desafiolatam.biblioteca.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.biblioteca.modelo.Libro;
import cl.desafiolatam.biblioteca.modelo.LibroMapper;

@Repository
public class LibroDaoImpl implements LibroDao {
	JdbcTemplate jdbcTemplate;

	@Autowired
	public LibroDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int add(Libro libro) {
		String query = "insert into LIBRO values (sq_libro.nextval, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(query, libro.getTitulo(), libro.getAutor(), libro.getAno(), libro.getImprenta(),
				libro.getDisponible());
	}

	@Override
	public int update(Libro libro) {
		String sql = "update libro set titulo=?, autor=?, ano=?, imprenta=?, disponible=? where id=?";
		return jdbcTemplate.update(sql, libro.getTitulo(), libro.getAutor(), libro.getAno(), libro.getImprenta(),
				libro.getDisponible(), libro.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "delete from libro where id=?";
		return jdbcTemplate.update(sql, id);

	}

	@Override
	public int disponible(int id) {
		Libro libro = new Libro();
		libro = findById(id); //busca el libro que tiene el id dado
		String disp = libro.getDisponible();//ve si esta o no disponible ese libro
		int result=0;
		
		if(disp.equals("si")) {
			result = jdbcTemplate.update("update libro set disponible='no' where id=?", id);
		}else{
			result = jdbcTemplate.update("update libro set disponible='si' where id=?", id);
			
		}

		return result;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Libro> findByAutorOrTitulo(String texto) {
		texto = "%"  + texto + "%";
		String query = "select * from LIBRO where autor like ? or titulo like ?";
		return jdbcTemplate.query(query, new Object[] {texto, texto}, new LibroMapper());
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Libro findById(int id) {
		String query = "select * from LIBRO where id=?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new LibroMapper());
	}

	@Override
	public List<Libro> findAll() {
		return jdbcTemplate.query("select * from libro", new LibroMapper());
	}
}
