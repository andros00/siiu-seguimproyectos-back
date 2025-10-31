package seguimproyectos_back.dao.participante.rol;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.model.participante.RolParticipanteDTO;

@Repository
public class RolParticipanteDao {

	private final JdbcTemplate jdbcTemplate;

	public RolParticipanteDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<RolParticipanteDTO> rolParticipantes() {
		String sql = "SELECT * FROM SIIU_ROL_PARTICIPANTE_PROYECTO"; //TABLE(SIIU_PARTICIPANTE_PROY_CRUD.SP_SELECT04)";

		return jdbcTemplate.query(sql, new RowMapper<RolParticipanteDTO>() {
			@Override
			public RolParticipanteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

				RolParticipanteDTO rol = new RolParticipanteDTO();

				rol.setIdentificador(rs.getInt("IDENTIFICADOR"));
				rol.setNombre(rs.getString("NOMBRE"));
//				rol.setTipoProyecto(rs.getInt("TIPO_PROYECTO"));
//				rol.setParticipaBeneficios(rs.getInt("PARTICIPA_BENEFICIOS"));
//				rol.setApoyaProgramaAcad(rs.getInt("APOYA_PROGRAMA_ACAD"));
//				rol.setTipoProgramaApoyado(rs.getString("TIPO_PROGRAMA_APOYADO"));
//				rol.setDescripcion(rs.getString("DESCRIPCION"));

//				Date inicioVigencia = rs.getDate("INICIO_VIGENCIA");
//				if (inicioVigencia != null) {
//					rol.setInicioVigencia(inicioVigencia.toLocalDate());
//				}

//				Date finVigencia = rs.getDate("FIN_VIGENCIA");
//				if (finVigencia != null) {
//					rol.setFinVigencia(finVigencia.toLocalDate());
//				}

//				rol.setRegistrador(rs.getString("REGISTRADOR"));
//				rol.setSelectorRegistrador(rs.getString("SELECTOR_REGISTRADOR"));

//				Date fechaUltimoCambio = rs.getDate("FECHA_ULTIMO_CAMBIO");
//				if (fechaUltimoCambio != null) {
//					rol.setFechaUltimoCambio(fechaUltimoCambio.toLocalDate());
//				}

//				rol.setEsInvestigadorPrincipal(rs.getInt("ES_INVESTIGADOR_PRINCIPAL"));
//				rol.setExclusivoUdea(rs.getInt("EXCLUSIVO_UDEA"));
//				rol.setProjectParticipantIdentificador(rs.getLong("PROJECT_PARTICIPANT_IDENTIFICADOR"));
//				rol.setRolParticipanteProyecto(rs.getLong("ROL_PARTICIPANTE_PROYECTO"));

				return rol;
			}
		});
	}

}
