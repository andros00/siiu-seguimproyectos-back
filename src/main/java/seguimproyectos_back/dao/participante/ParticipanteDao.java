package seguimproyectos_back.dao.participante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.dao.UdeaException;
import seguimproyectos_back.model.participante.ParticipanteDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalRequest;

@Repository
public class ParticipanteDao {

	private final JdbcTemplate jdbcTemplate;

	public ParticipanteDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return valor.trim();
	}

	public List<ParticipanteDTO> actualizarParticipante(ParticipanteDTO participante) throws UdeaException {
		String sql = "SELECT * from TABLE (cast(gene_consultas.buscarpersonanatural(?,?,?) as obj_tab_personanatural));";

		return jdbcTemplate.query(sql, new Object[] { formatSqlLike(participante.getIdentificador()) },
				new RowMapper<ParticipanteDTO>() {

					@Override
					public ParticipanteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						ParticipanteDTO p = new ParticipanteDTO();
						return p;
					}
				});
	}
}
