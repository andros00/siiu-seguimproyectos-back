package seguimproyectos_back.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import co.edu.udea.utilities.exception.UdeaException;
import oracle.jdbc.OracleTypes;
import seguimproyectos_back.model.Proyecto;

@Repository
public class ConsultaProyectosDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ConsultaProyectosDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	    private String formatSqlLike(String valor) {
	        if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
	            return "%";
	        }
	        return "%" + valor.trim() + "%";
	    }

	    public List<Proyecto> consultaProyectos(Proyecto proyecto) {
	        String sql = "SELECT * FROM TABLE(SIIU_PROYECTO_CRUD.SP_SELECT001(?, ?, ?, ?, ?, ?))";

	        return jdbcTemplate.query(sql,
	                new Object[] {
	                        formatSqlLike(proyecto.getCodigo()),
	                        (proyecto.getIdCentroGestion()),
	                        formatSqlLike(proyecto.getEstado()),
	                        (proyecto.getProcesoSeleccion()),
	                        (proyecto.getConvocatoria()),
	                        (proyecto.getSubtipoProyecto())
	                        
	                },
	                new RowMapper<Proyecto>() {
	                    @Override
	                    public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
	                        Proyecto p = new Proyecto();
	                        p.setCodigo(rs.getString("CODIGO"));           
	                        p.setNombreCorto(rs.getString("NOMBRE_CORTO"));
	                        p.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
	                        p.setEstado(rs.getString("ESTADO"));
	                        p.setConvocatoria(rs.getLong("CONVOCATORIA"));
	                        p.setProcesoSeleccion(rs.getLong("PROCESO_SELECCION"));
	                        p.setResponsable(rs.getString("RESPONSABLE"));
	                        p.setNombreCompletoResponsable(rs.getString("NOMBRE_RESPONSABLE"));
	                        p.setTipoProyectoNombre(rs.getString("TIPO_PROYECTO_NOMBRE"));
	                        p.setNombreCortoConvocatoria(rs.getString("NOMBRE_CORTO_CONVOCATORIA"));
	                        p.setNombreSubnivelProyecto(rs.getString("NOMBRE_SUBNIVEL_PROYECTO"));
	                        p.setNombreProcesoSeleccion(rs.getString("NOMBRE_PROCESO_SELECCION"));
	                        p.setIpCoordinadorProyecto(rs.getString("IP_O_COORDINADOR"));
	                        p.setDuracion(rs.getLong("DURACION"));
	                        p.setFechaInicioInicioFormal(rs.getDate("FECHA_INICIO"));
	                        p.setFechaInicioFinalizacionFormal(rs.getDate("FECHA_FINALIZACION"));

	                        
	                        
//	                        p.setSubtipoProyecto(rs.getLong("SUBTIPO_PROYECTO"));

//	                        p.setCentroGestionStr(rs.getString("NOMBRE_CENTRO_GESTION"));
//	                        p.setCentroGestionCortoStr(rs.getString("NOMBRE_CORTO_CENTRO_GESTION"));
//	                        p.setMaxProrrogaInicioFormal(rs.getLong("MAX_PRORROGA_INI_FORMAL"));
//	                        p.setMaxProrrogaEjecucion(rs.getLong("MAX_PRORROGA_EJECUCION"));
//	                        p.setNombreCortoConvocatoria(rs.getString("NOMBRE_CORTO_CONVOCATORIA"));
//	                        p.setIdCentroGestion(rs.getLong("CENTRO_GESTION"));
//	                        p.setEtapaActual(rs.getLong("ETAPA_ACTUAL"));
//	                        p.setInstanciaAdmtivaActual(rs.getLong("INSTANCIA_ADMTIVA_ACTUAL"));
//	                        p.setCentroGestion(rs.getLong("CENTRO_GESTION"));
//	                        p.setModalidadConvocatoria(rs.getLong("MODALIDAD_CONVOCATORIA"));
//	                        p.setSelectorResponsable(rs.getString("SELECTOR_RESPONSABLE"));
//	                        p.setSeccional(rs.getString("SECCIONAL"));
//	                        p.setSelectorSeccional(rs.getString("SELECTOR_SECCIONAL"));	              
//	                        p.setPalabrasClaves(rs.getString("PALABRAS_CLAVES"));
//	                        p.setLugarEjecucion(rs.getString("LUGAR_EJECUCION"));
//	                        p.setMoneda(rs.getString("MONEDA"));
//	                        p.setPendienteAjustePpto(rs.getLong("PENDIENTE_AJUSTE_PPTO"));
//	                        p.setPeriodoCronograma(rs.getString("PERIODO_CRONOGRAMA"));
	                       
	                        return p;
	                    }
	                });
	    }

}
