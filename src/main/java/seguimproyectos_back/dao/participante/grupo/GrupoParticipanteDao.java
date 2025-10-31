package seguimproyectos_back.dao.participante.grupo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.participante.grupo.GrupoParticipanteDTO;

@Repository
public class GrupoParticipanteDao {

	private final JdbcTemplate jdbcTemplate;

	public GrupoParticipanteDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return valor.trim();
	}

	public List<GrupoParticipanteDTO> consultarGrupoParticipante(String indentificador) throws UdeaException {

		String sql = "SELECT * FROM TABLE(SIIU_PARTICIPANTE_PROY_CRUD.SP_SELECT03(?,?))";

		return jdbcTemplate.query(sql, new Object[] { formatSqlLike("Habilitado"), formatSqlLike(indentificador) },
				new RowMapper<GrupoParticipanteDTO>() {
					@Override
					public GrupoParticipanteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

						GrupoParticipanteDTO grupo = new GrupoParticipanteDTO();

						grupo.setIdentificador(rs.getLong("IDENTIFICADOR"));
						grupo.setNombreCorto(rs.getString("NOMBRE_CORTO"));

						return grupo;
					}
				});
	}

}
