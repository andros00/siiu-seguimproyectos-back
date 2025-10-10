package seguimproyectos_back.dao;

import java.sql.CallableStatement;
import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.ProyectoIniFormalDTO;

@Repository
public class ProyectoIniFormalDao {

	private final JdbcTemplate jdbcTemplate;

	public ProyectoIniFormalDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return valor.trim();
	}

	public ProyectoIniFormalDTO consultarInicioFormal(String codigoProyecto) throws UdeaException {
		String sql = "SELECT * FROM TABLE(SMAP_PROY_IFORMAL_CRUD.SP_SELECT(?))";

		return jdbcTemplate.queryForObject(sql, new Object[] { formatSqlLike(codigoProyecto) }, (rs, rowNum) -> {
			ProyectoIniFormalDTO p = new ProyectoIniFormalDTO();
			p.setId(rs.getLong("ID"));
			p.setCodigoProyecto(rs.getString("PRO_CODIGO"));
			p.setDuracion(rs.getLong("PRO_DURACION"));
			p.setFechaInicio(rs.getDate("FECHA_INICIO"));
			p.setFechaFinalizacion(rs.getDate("FECHA_FINALIZACION"));
			p.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
//	            p.setNombreCorto(rs.getString("PRO_NOMBRE_CORTO"));
//	            p.setNombreCompleto(rs.getString("PRO_NOMBRE_COMPLETO"));
	        p.setFechaAprobacionRechazo(rs.getDate("FECHA_APROBACION_RECHAZO"));
			p.setEstado(rs.getString("ESTADO"));
			p.setFechaAprobacionProyCodi(rs.getDate("FECHA_APROB_PROY_CODI"));
			p.setCodigoAprobacionActaCodi(rs.getString("CODIGO_APROB_ACTA_CODI"));
			p.setFechaCrea(rs.getDate("FECHA_CREA"));
			p.setUsuarioCrea(rs.getString("USUARIO_CREA"));

			return p;
		});
	}

	public ProyectoIniFormalDTO actualizarInicioFormal(ProyectoIniFormalDTO proyecto) throws UdeaException {
	    String sql = "{ ? = call SMAP_PROY_IFORMAL_CRUD.SP_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?) }";

	    jdbcTemplate.execute(sql, (CallableStatement cs) -> {
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.setString(2, proyecto.getEstado());
	        cs.setLong(3, proyecto.getDuracion());
	        cs.setDate(4, proyecto.getFechaInicio() != null ? new java.sql.Date(proyecto.getFechaInicio().getTime()) : null);
	        cs.setDate(5, proyecto.getFechaFinalizacion() != null ? new java.sql.Date(proyecto.getFechaFinalizacion().getTime()) : null);
	        cs.setString(6, proyecto.getUsuarioModifica() != null ? proyecto.getUsuarioModifica() : "");
	        cs.setString(7, proyecto.getCodigoInterno());
	        cs.setString(8, proyecto.getCodigoAprobacionActaCodi() != null ? proyecto.getCodigoAprobacionActaCodi() : "");
	        cs.setDate(9, proyecto.getFechaAprobacionProyCodi() != null ? new java.sql.Date(proyecto.getFechaAprobacionProyCodi().getTime()) : null);
	        cs.setLong(10, proyecto.getId());
	        cs.execute();
	        return null;
	    });

	    // Consulta el registro actualizado
	 // Luego consultas el registro actualizado y lo mapeas manualmente
	    String selectSql = "SELECT ID, ESTADO, DURACION, FECHA_INICIO, FECHA_FINALIZACION, USUARIO_MODIFICA, " +
	                       "CODIGO_INTERNO, CODIGO_APROB_ACTA_CODI, FECHA_APROB_PROY_CODI " +
	                       "FROM SMAP_PROYECTO_IFORMAL WHERE ID = ?";

	    return jdbcTemplate.query(selectSql, ps -> ps.setLong(1, proyecto.getId()), rs -> {
	        if (rs.next()) {
	            ProyectoIniFormalDTO actualizado = new ProyectoIniFormalDTO();
	            actualizado.setId(rs.getLong("ID"));
	            actualizado.setEstado(rs.getString("ESTADO"));
	            actualizado.setDuracion(rs.getLong("DURACION"));
	            actualizado.setFechaInicio(rs.getDate("FECHA_INICIO"));
	            actualizado.setFechaFinalizacion(rs.getDate("FECHA_FINALIZACION"));
	            actualizado.setUsuarioModifica(rs.getString("USUARIO_MODIFICA"));
	            actualizado.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
	            actualizado.setCodigoAprobacionActaCodi(rs.getString("CODIGO_APROB_ACTA_CODI"));
	            actualizado.setFechaAprobacionProyCodi(rs.getDate("FECHA_APROB_PROY_CODI"));
	            return actualizado;
	        }
	        return null;
	    });
	}

}
