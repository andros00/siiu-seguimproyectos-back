package seguimproyectos_back.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.model.ActividadProyectoDTO;

@Repository
public class ActividadProyectoDao {
	
	private final JdbcTemplate jdbcTemplate;

	public ActividadProyectoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Retorna la lista de actividades de un proyecto específico.
	 * 
	 * @param proyecto Código o identificador del proyecto (VARCHAR2(20))
	 * @return Lista de actividades del proyecto.
	 */
	public List<ActividadProyectoDTO> consultarActividadXProyecto(String proyecto) {
		String sql = "SELECT * FROM TABLE(SIIU_ACTIVIDAD_PROYECTO_CRUD.SP_SELECT(?))";
		
		return jdbcTemplate.query(sql, new Object[] { proyecto }, new RowMapper<ActividadProyectoDTO>() {
			@Override
			public ActividadProyectoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ActividadProyectoDTO p = new ActividadProyectoDTO();
				p.setIdentificador(rs.getLong("IDENTIFICADOR"));
				//p.setProyecto(rs.getString("PROYECTO"));
				p.setOrden(rs.getInt("ORDEN"));
				p.setConsecutivo(rs.getInt("CONSECUTIVO"));
				p.setInicio(rs.getInt("INICIO"));
				p.setFin(rs.getInt("FIN"));
				p.setNombre(rs.getString("NOMBRE"));
				p.setDetalle(rs.getString("DETALLE"));
				return p;
			}
		});
	}
}
