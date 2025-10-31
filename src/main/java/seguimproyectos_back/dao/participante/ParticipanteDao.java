package seguimproyectos_back.dao.participante;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Collections;

import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.participante.ParticipanteDTO;

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

	public int actualizarParticipante(ParticipanteDTO participante) throws UdeaException {
	    final String sql = "{ ? = call SIIU_PARTICIPANTE_PROY_CRUD.SP_UPDATE(" 
	            + String.join(",", Collections.nCopies(30, "?")) + ") }";

	    return jdbcTemplate.execute(sql, (CallableStatementCallback<Integer>) cs -> {

	        cs.registerOutParameter(1, Types.NUMERIC);
	        

	        // 1–6: Campos básicos de vinculación
	        cs.setString(2, formatSqlLike(participante.getProyecto()));
	        cs.setString(3, formatSqlLike(participante.getPersonaNatural()));
	        cs.setString(4, formatSqlLike(participante.getSelectorPersona()));
	        cs.setString(5, formatSqlLike(participante.getVinculacionUdea()));
	        cs.setString(6, formatSqlLike(participante.getVinculacionTipo()));
	        cs.setString(7, formatSqlLike(participante.getVinculacionClase()));

	        // 7: COD_PROGRAMA_APOYADO
	        if (participante.getCodProgramaApoyado() != null)
	            cs.setInt(8, participante.getCodProgramaApoyado());
	        else
	            cs.setNull(8, Types.NUMERIC);

	        // 8: ANONIMO
	        if (participante.getAnonimo() != null)
	            cs.setObject(9, participante.getAnonimo(), Types.NUMERIC);
	        else
	            cs.setNull(9, Types.NUMERIC);

	     // 9–10: FECHAS
	        if (participante.getFechaInicio() != null)
	            cs.setTimestamp(10, Timestamp.valueOf(participante.getFechaInicio()));
	        else
	            cs.setNull(10, Types.TIMESTAMP);

	        if (participante.getFechaFin() != null)
	            cs.setTimestamp(11, Timestamp.valueOf(participante.getFechaFin()));
	        else
	            cs.setNull(11, Types.TIMESTAMP);

	        // 11: ROL_PARTICIPANTE_PROYECTO
	        if (participante.getRolParticipanteProyecto() != null)
	            cs.setInt(12, participante.getRolParticipanteProyecto());
	        else
	            cs.setNull(12, Types.NUMERIC);

	        // 12–14: Institución y grupo
	        cs.setString(13, formatSqlLike(participante.getInstitucion()));
	        cs.setString(14, formatSqlLike(participante.getSelectorInstitucion()));

	        if (participante.getGrupo() != null)
	            cs.setInt(15, participante.getGrupo());
	        else
	            cs.setNull(15, Types.NUMERIC);

	        // 15–18: Dedicaciones
	        if (participante.getDedicacionMeses() != null)
	            cs.setBigDecimal(16, participante.getDedicacionMeses());
	        else
	            cs.setNull(16, Types.NUMERIC);

	        if (participante.getDedicacionHoras() != null)
	            cs.setBigDecimal(17, participante.getDedicacionHoras());
	        else
	            cs.setNull(17, Types.NUMERIC);

	        if (participante.getDedicacionMesesPlan() != null)
	            cs.setBigDecimal(18, participante.getDedicacionMesesPlan());
	        else
	            cs.setNull(18, Types.NUMERIC);

	        if (participante.getDedicacionHorasPlan() != null)
	            cs.setBigDecimal(19, participante.getDedicacionHorasPlan());
	        else
	            cs.setNull(19, Types.NUMERIC);

	        // 19–23: Datos de rol, observación, usuario y llave
	        if (participante.getPorcentajeBeneficios() != null)
	            cs.setInt(20, participante.getPorcentajeBeneficios());
	        else
	            cs.setNull(20, Types.NUMERIC);

	        cs.setString(21, formatSqlLike(participante.getFuncion()));
	        cs.setString(22, formatSqlLike(participante.getObservacion()));
	        cs.setString(23, formatSqlLike(participante.getUsuarioActualiza()));

	        if (participante.getIdentificador() != null)
	            cs.setInt(24, participante.getIdentificador());
	        else
	            cs.setNull(24, Types.NUMERIC);

	        // 24–30: Información de contacto y contrato
	        cs.setString(25, formatSqlLike(participante.getNombre()));
	        cs.setString(26, formatSqlLike(participante.getCorreo()));

	        if (participante.getNotaAclaratoria() != null && participante.getNotaAclaratoria() > 0) {
	            cs.setInt(27, participante.getNotaAclaratoria());
	        } else {
	            cs.setNull(27, Types.NUMERIC);
	        }

	        cs.setString(28, formatSqlLike(participante.getNotaAclaratoriaGeneral()));
	        cs.setString(29, formatSqlLike(participante.getTipoContrato()));
	        cs.setString(30, formatSqlLike(participante.getDetalleContrato()));
	        cs.setString(31, formatSqlLike(participante.getNombreProgramaExterno()));
	        
	      System.out.println("Lista de json::::::"+  cs.toString());

	        cs.execute();
	        return cs.getInt(1);
	    });
	}


}
