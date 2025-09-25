package seguimproyectos_back.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.model.AdministrativeCenterDTO;

@Repository
public class CentroAdministrativoDao {

	private final JdbcTemplate jdbcTemplate;

	public CentroAdministrativoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return "%" + valor.trim() + "%";
	}

	public List<AdministrativeCenterDTO> getAll() {
		String sql = "SELECT * FROM SIIU_INSTANCIA_ADMINISTRATIVA ps";

		return jdbcTemplate.query(sql, new RowMapper<AdministrativeCenterDTO>() {
			@Override
			public AdministrativeCenterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdministrativeCenterDTO p = new AdministrativeCenterDTO();
				p.setId(rs.getLong("IDENTIFICADOR"));
				p.setShortName(rs.getString("NOMBRE"));
				return p;
			}
		});
	}

}
