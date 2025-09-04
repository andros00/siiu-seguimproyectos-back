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
	        String sql = "SELECT * FROM TABLE(SIIU_PROYECTO_CRUD.SP_SELECT01(?, ?, ?, ?, ?, ?, ?))";

	        return jdbcTemplate.query(sql,
	                new Object[] {
	                        formatSqlLike(proyecto.getCodigo()),
	                        formatSqlLike(proyecto.getCentroGestionStr()),
	                        formatSqlLike(proyecto.getPalabrasClaves()),
	                        formatSqlLike(proyecto.getNombreCorto()),
	                        formatSqlLike(proyecto.getNombreCompleto()),
	                        formatSqlLike(proyecto.getFinanciador()),
	                        formatSqlLike(proyecto.getEstado())
	                },
	                new RowMapper<Proyecto>() {
	                    @Override
	                    public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
	                        Proyecto p = new Proyecto();
	                        p.setCodigo(rs.getString("CODIGO"));
	                        p.setConvocatoria(rs.getLong("CONVOCATORIA"));
	                        p.setModalidadConvocatoria(rs.getLong("MODALIDAD_CONVOCATORIA"));
	                        p.setProcesoSeleccion(rs.getLong("PROCESO_SELECCION"));
	                        p.setSubtipoProyecto(rs.getLong("SUBTIPO_PROYECTO"));
	                        p.setSubtipoProyectoNombre(rs.getString("SUBTIPO_PROYECTO_NOMBRE"));
	                        p.setTipoProyectoNombre(rs.getString("TIPO_PROYECTO_NOMBRE"));
	                        p.setEtapaActual(rs.getLong("ETAPA_ACTUAL"));
	                        p.setInstanciaAdmtivaActual(rs.getLong("INSTANCIA_ADMTIVA_ACTUAL"));
	                        p.setCentroGestion(rs.getLong("CENTRO_GESTION"));
	                        p.setResponsable(rs.getString("RESPONSABLE"));
	                        p.setSelectorResponsable(rs.getString("SELECTOR_RESPONSABLE"));
	                        p.setSeccional(rs.getString("SECCIONAL"));
	                        p.setSelectorSeccional(rs.getString("SELECTOR_SECCIONAL"));
	                        p.setEstado(rs.getString("ESTADO"));
	                        p.setNombreCorto(rs.getString("NOMBRE_CORTO"));
	                        p.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
	                        p.setPalabrasClaves(rs.getString("PALABRAS_CLAVES"));
	                        p.setDuracion(rs.getLong("DURACION"));
	                        p.setLugarEjecucion(rs.getString("LUGAR_EJECUCION"));
	                        p.setMoneda(rs.getString("MONEDA"));
	                        p.setPendienteAjustePpto(rs.getLong("PENDIENTE_AJUSTE_PPTO"));
	                        p.setPeriodoCronograma(rs.getString("PERIODO_CRONOGRAMA"));
	                        p.setFechaInicioInicioFormal(rs.getDate("FECHA_INICIO"));
	                        p.setFechaInicioFinalizacionFormal(rs.getDate("FECHA_FINALIZACION"));
	                        p.setCentroGestionStr(rs.getString("NOMBRE_CENTRO_GESTION"));
	                        p.setCentroGestionCortoStr(rs.getString("NOMBRE_CORTO_CENTRO_GESTION"));
	                        p.setMaxProrrogaInicioFormal(rs.getLong("MAX_PRORROGA_INI_FORMAL"));
	                        p.setMaxProrrogaEjecucion(rs.getLong("MAX_PRORROGA_EJECUCION"));
	                        p.setNombreCortoConvocatoria(rs.getString("NOMBRE_CORTO_CONVOCATORIA"));
	                        p.setIdCentroGestion(rs.getLong("CENTRO_GESTION"));
	                        return p;
	                    }
	                });
	    }

}
