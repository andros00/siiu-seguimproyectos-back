package seguimproyectos_back.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.model.SelectionProcessDTO;

@Repository
public class ProcesoSeleccionDao {

	private final JdbcTemplate jdbcTemplate;

	public ProcesoSeleccionDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return "%" + valor.trim() + "%";
	}

	public List<SelectionProcessDTO> getAll() {
		String sql = "SELECT * FROM siiu_proceso_seleccion ps";

		return jdbcTemplate.query(sql, new RowMapper<SelectionProcessDTO>() {
			@Override
			public SelectionProcessDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				SelectionProcessDTO p = new SelectionProcessDTO();
				p.setId(rs.getLong("IDENTIFICADOR"));
				p.setName(rs.getString("NOMBRE"));
				return p;
			}
		});
	}

}
