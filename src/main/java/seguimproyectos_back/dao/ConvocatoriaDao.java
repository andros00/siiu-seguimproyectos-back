package seguimproyectos_back.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.model.AnnouncementDTO;
import seguimproyectos_back.model.SelectionProcessDTO;

@Repository
public class ConvocatoriaDao {

	private final JdbcTemplate jdbcTemplate;

	public ConvocatoriaDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return "%" + valor.trim() + "%";
	}

	public List<AnnouncementDTO> getAll() {
		String sql = "SELECT * FROM SIIU_CONVOCATORIA cn";

		return jdbcTemplate.query(sql, new RowMapper<AnnouncementDTO>() {
			@Override
			public AnnouncementDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				AnnouncementDTO p = new AnnouncementDTO();
				p.setId(rs.getLong("IDENTIFICADOR"));
				p.setName(rs.getString("NOMBRE"));
				return p;
			}
		});
	}
}
