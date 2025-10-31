package seguimproyectos_back.dao.compromiso.nota;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.compromiso.CompromisoNotaDTO;

@Repository
public class CompromisoNotaDao {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public CompromisoNotaDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Inserta una nueva nota de compromiso usando el procedimiento almacenado:
	 * SMAP_COMPROMISO_NOTA_CRUD.SP_INSERT
	 */
	public int insert(CompromisoNotaDTO nota) throws UdeaException {
		String sql = "{ ? = call SMAP_COMPROMISO_NOTA_CRUD.SP_INSERT(?, ?, ?, ?, ?) }";

		return jdbcTemplate.execute(con -> {
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER); // RETORNO
			cs.setObject(2, nota.getIdCompromisoProyecto(), Types.INTEGER);
			cs.setString(3, nota.getNota());
			cs.setString(4, nota.getUsuarioCrea());
			cs.setDate(5, new java.sql.Date(nota.getFechaCrea().getTime()));
			cs.registerOutParameter(6, Types.NUMERIC); // P_IDENTIFICADOR
			return cs;
		}, (CallableStatementCallback<Integer>) cs -> {
			cs.execute();
			// Asignar el identificador generado al DTO
			Object idGenerado = cs.getObject(6);
			if (idGenerado != null) {
				nota.setIdentificador(((Number) idGenerado).longValue());
			}
			return cs.getInt(1); // RETORNO
		});

	}

	/**
	 * Consulta las notas asociadas a un compromiso por proyecto. Usa:
	 * SMAP_COMPROMISO_NOTA_CRUD.SP_SELECT01
	 */
	public List<CompromisoNotaDTO> findByCompromisoProyecto(Long idCompromisoProyecto) throws UdeaException {
		String sql = "SELECT * FROM TABLE(SMAP_COMPROMISO_NOTA_CRUD.SP_SELECT01(?))";

		return jdbcTemplate.query(sql, new Object[] { idCompromisoProyecto }, (ResultSet rs, int rowNum) -> {
			CompromisoNotaDTO n = new CompromisoNotaDTO();
			n.setIdentificador(rs.getLong("IDENTIFICADOR"));
			n.setIdCompromisoProyecto(rs.getLong("ID_COMPROMISO_PROYECTO"));
			n.setNota(rs.getString("NOTA"));
			n.setUsuarioCrea(rs.getString("USUARIO_CREA"));
			n.setFechaCrea(rs.getDate("FECHA_CREA"));
			return n;
		});
	}

}
