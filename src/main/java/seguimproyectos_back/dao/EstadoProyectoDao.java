package seguimproyectos_back.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.model.EstadoProyectoDTO;

@Repository
public class EstadoProyectoDao {
	
	private final JdbcTemplate jdbcTemplate;

	public EstadoProyectoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return "%" + valor.trim() + "%";
	}

	public List<EstadoProyectoDTO> getAll() {
		String sql = "SELECT * FROM SIIU_ESTADO_PROYECTO";

		return jdbcTemplate.query(sql, new RowMapper<EstadoProyectoDTO>() {
			@Override
			public EstadoProyectoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EstadoProyectoDTO p = new EstadoProyectoDTO();
				p.setId(rs.getLong("IDENTIFICADOR"));
				p.setShortName(rs.getString("ESTADO"));
				return p;
			}
		});
	}

}
