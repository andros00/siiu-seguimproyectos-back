package seguimproyectos_back.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.model.ProjectTypeDTO;

@Repository
public class TipoProyectoDao {

	private final JdbcTemplate jdbcTemplate;

	public TipoProyectoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return "%" + valor.trim() + "%";
	}

	public List<ProjectTypeDTO> getAll() {
		String sql = "SELECT * FROM siiu_tipo_proyecto tp";

		return jdbcTemplate.query(sql, new RowMapper<ProjectTypeDTO>() {
			@Override
			public ProjectTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProjectTypeDTO p = new ProjectTypeDTO();
				p.setId(rs.getLong("IDENTIFICADOR"));
				p.setName(rs.getString("NOMBRE"));
				return p;
			}
		});
	}
}
