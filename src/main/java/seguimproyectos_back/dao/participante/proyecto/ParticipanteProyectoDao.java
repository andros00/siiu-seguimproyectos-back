package seguimproyectos_back.dao.participante.proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.ParticipanteDTO;
import seguimproyectos_back.model.ParticipanteProyectoDTO;
import seguimproyectos_back.model.ProyectoDTO;

@Repository
public class ParticipanteProyectoDao {

	private final JdbcTemplate jdbcTemplate;

	public ParticipanteProyectoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return valor.trim();
	}

	public List<ParticipanteProyectoDTO> consultarParticipantes(String codigoProyecto) throws UdeaException {
		String sql = "SELECT * FROM TABLE(SIIU_PARTICIPANTE_PROY_CRUD.SP_SELECT07(?))";

		return jdbcTemplate.query(sql, new Object[] { formatSqlLike(codigoProyecto) },
				new RowMapper<ParticipanteProyectoDTO>() {
					@Override
					public ParticipanteProyectoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						ParticipanteProyectoDTO participanteProyecto = new ParticipanteProyectoDTO();
						participanteProyecto.setIdentificador(rs.getBigDecimal("IDENTIFICADOR"));
						participanteProyecto.setProyecto(rs.getString("PROYECTO"));
						participanteProyecto.setPersonaNatural(rs.getString("PERSONA_NATURAL"));
						participanteProyecto.setSelectorPersona(rs.getString("SELECTOR_PERSONA"));
						participanteProyecto.setVinculacionUdea(rs.getString("VINCULACION_UDEA"));
						participanteProyecto.setVinculacionTipo(rs.getString("VINCULACION_TIPO"));
						participanteProyecto.setVinculacionClase(rs.getString("VINCULACION_CLASE"));
						participanteProyecto.setCodProgramaApoyado(rs.getLong("COD_PROGRAMA_APOYADO"));
						participanteProyecto.setAnonimo(rs.getLong("ANONIMO"));
						participanteProyecto.setFechaInicio(rs.getDate("FECHA_INICIO"));
						participanteProyecto.setFechaFin(rs.getDate("FECHA_FIN"));
						participanteProyecto
								.setRolParticipanteProyecto(Long.valueOf(rs.getLong("ROL_PARTICIPANTE_PROYECTO")));
						participanteProyecto.setRolParticipante(rs.getString("ROL_PARTICIPANTE"));
						participanteProyecto.setInstitucion(rs.getString("INSTITUCION"));
						participanteProyecto.setSelectorInstitucion(rs.getString("SELECTOR_INSTITUCION"));
						participanteProyecto.setGrupo(rs.getBigDecimal("GRUPO"));
						participanteProyecto.setDedicacionMeses(Long.valueOf(rs.getLong("DEDICACION_MESES")));
						participanteProyecto.setDedicacionHoras(Long.valueOf(rs.getLong("DEDICACION_HORAS")));
						participanteProyecto.setDedicacionMesesPlan(Long.valueOf(rs.getLong("DEDICACION_MESES_PLAN")));
						participanteProyecto.setDedicacionHorasPlan(Long.valueOf(rs.getLong("DEDICACION_HORAS_PLAN")));
						participanteProyecto.setPorcentajeBeneficios(Long.valueOf(rs.getLong("PORCENTAJE_BENEFICIOS")));
						participanteProyecto.setFuncion(rs.getString("FUNCION"));
						participanteProyecto.setObservacion(rs.getString("OBSERVACION"));
						participanteProyecto.setUsuarioCrea(rs.getString("USUARIO_CREA"));
						participanteProyecto.setFechaCrea(rs.getDate("FECHA_CREA"));
						participanteProyecto.setUsuarioActualiza(rs.getString("USUARIO_ACTUALIZA"));
						participanteProyecto.setFechaActualiza(rs.getDate("FECHA_ACTUALIZA"));
						participanteProyecto.setCodFaculProgApoy(rs.getLong("COD_FACUL_PROG_APOY"));
						participanteProyecto.setPorcentajeProgAcad(rs.getLong("PORCENTAJE_PROG_ACAD"));
						participanteProyecto.setParticipaBeneficios(rs.getString("PARTICIPA_BENEFICIOS"));
						participanteProyecto.setDedicacionNN(participanteProyecto.getDedicacionHoras() + " H - "
								+ participanteProyecto.getDedicacionMeses() + " M");
						participanteProyecto.setNombreGrupo(rs.getString("NOMBRE_CORTO_GRUPO"));
						participanteProyecto.setNombrePersona(rs.getString("NOMBRE_PERSONA"));
						participanteProyecto.setTipoContrato(rs.getString("TIPO_CONTRATO"));
						participanteProyecto.setDetalleContrato(rs.getString("DETALLE_CONTRATO"));
						participanteProyecto.setNombreProgramaExterno(rs.getString("NOMBRE_PROGRAMA_EXTERNO"));
						if (participanteProyecto.getNombrePersona().length() <= 5) {
							participanteProyecto.setNombrePersona(rs.getString("PERSONA_NATURAL"));
						}
						participanteProyecto.setEsInvestigadorPrincipal(rs.getInt("ES_INVESTIGADOR_PRINCI"));
						return participanteProyecto;
					}
				});
	}

	public ParticipanteProyectoDTO consultarParticipantePorId(String identificacion) throws UdeaException {
		String sql = "SELECT * FROM TABLE(SIIU_PARTICIPANTE_PROY_CRUD.SP_SELECT07(?))";

		return jdbcTemplate.queryForObject(sql, new Object[] { formatSqlLike(identificacion) }, (rs, rowNum) -> {
			ParticipanteProyectoDTO participanteProyecto = new ParticipanteProyectoDTO();
			participanteProyecto.setIdentificador(rs.getBigDecimal("IDENTIFICADOR"));
			participanteProyecto.setProyecto(rs.getString("PROYECTO"));
			participanteProyecto.setPersonaNatural(rs.getString("PERSONA_NATURAL"));
			participanteProyecto.setSelectorPersona(rs.getString("SELECTOR_PERSONA"));
			participanteProyecto.setVinculacionUdea(rs.getString("VINCULACION_UDEA"));
			participanteProyecto.setVinculacionTipo(rs.getString("VINCULACION_TIPO"));
			participanteProyecto.setVinculacionClase(rs.getString("VINCULACION_CLASE"));
			participanteProyecto.setCodProgramaApoyado(rs.getLong("COD_PROGRAMA_APOYADO"));
			participanteProyecto.setAnonimo(rs.getLong("ANONIMO"));
			participanteProyecto.setFechaInicio(rs.getDate("FECHA_INICIO"));
			participanteProyecto.setFechaFin(rs.getDate("FECHA_FIN"));
			participanteProyecto.setRolParticipanteProyecto(Long.valueOf(rs.getLong("ROL_PARTICIPANTE_PROYECTO")));
			participanteProyecto.setRolParticipante(rs.getString("ROL_PARTICIPANTE"));
			participanteProyecto.setInstitucion(rs.getString("INSTITUCION"));
			participanteProyecto.setSelectorInstitucion(rs.getString("SELECTOR_INSTITUCION"));
			participanteProyecto.setGrupo(rs.getBigDecimal("GRUPO"));
			participanteProyecto.setDedicacionMeses(Long.valueOf(rs.getLong("DEDICACION_MESES")));
			participanteProyecto.setDedicacionHoras(Long.valueOf(rs.getLong("DEDICACION_HORAS")));
			participanteProyecto.setDedicacionMesesPlan(Long.valueOf(rs.getLong("DEDICACION_MESES_PLAN")));
			participanteProyecto.setDedicacionHorasPlan(Long.valueOf(rs.getLong("DEDICACION_HORAS_PLAN")));
			participanteProyecto.setPorcentajeBeneficios(Long.valueOf(rs.getLong("PORCENTAJE_BENEFICIOS")));
			participanteProyecto.setFuncion(rs.getString("FUNCION"));
			participanteProyecto.setObservacion(rs.getString("OBSERVACION"));
			participanteProyecto.setUsuarioCrea(rs.getString("USUARIO_CREA"));
			participanteProyecto.setFechaCrea(rs.getDate("FECHA_CREA"));
			participanteProyecto.setUsuarioActualiza(rs.getString("USUARIO_ACTUALIZA"));
			participanteProyecto.setFechaActualiza(rs.getDate("FECHA_ACTUALIZA"));
			participanteProyecto.setCodFaculProgApoy(rs.getLong("COD_FACUL_PROG_APOY"));
			participanteProyecto.setPorcentajeProgAcad(rs.getLong("PORCENTAJE_PROG_ACAD"));
			participanteProyecto.setParticipaBeneficios(rs.getString("PARTICIPA_BENEFICIOS"));
			participanteProyecto.setDedicacionNN(participanteProyecto.getDedicacionHoras() + " H - "
					+ participanteProyecto.getDedicacionMeses() + " M");
			participanteProyecto.setNombreGrupo(rs.getString("NOMBRE_CORTO_GRUPO"));
			participanteProyecto.setNombrePersona(rs.getString("NOMBRE_PERSONA"));
			participanteProyecto.setTipoContrato(rs.getString("TIPO_CONTRATO"));
			participanteProyecto.setDetalleContrato(rs.getString("DETALLE_CONTRATO"));
			participanteProyecto.setNombreProgramaExterno(rs.getString("NOMBRE_PROGRAMA_EXTERNO"));
			if (participanteProyecto.getNombrePersona().length() <= 5) {
				participanteProyecto.setNombrePersona(rs.getString("PERSONA_NATURAL"));
			}
			participanteProyecto.setEsInvestigadorPrincipal(rs.getInt("ES_INVESTIGADOR_PRINCI"));
			return participanteProyecto;

		});
	}
}
