package seguimproyectos_back.dao.participante.vinculo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import seguimproyectos_back.dao.participante.proyecto.UdeaException;
import seguimproyectos_back.model.participante.VinculoParticipanteDTO;

@Repository
public class VinculoParticipanteDao {	

	private final JdbcTemplate jdbcTemplate;

	public VinculoParticipanteDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return valor.trim();
	}

	public List<VinculoParticipanteDTO> consultarParticipantes(String indentificador) throws UdeaException {

		LocalDateTime fechaHoraActual = LocalDateTime.now();

		String sql = "SELECT * FROM TABLE(gene_consultas.buscarvinculoempleado(?,'')";

		return jdbcTemplate.query(sql,
				new Object[] { formatSqlLike(indentificador), formatSqlLike(fechaHoraActual.toString()) },
				new RowMapper<VinculoParticipanteDTO>() {
					@Override
					public VinculoParticipanteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						VinculoParticipanteDTO vinculo = new VinculoParticipanteDTO();

						vinculo.setSecuenciaVinculacion(rs.getLong("SECUENCIA_VINCULACION"));
						vinculo.setCodigoTipoVinculacion(rs.getString("CODIGO_TIPO_VINCULACION"));
						vinculo.setNombreTipoVinculacion(rs.getString("NOMBRE_TIPO_VINCULACION"));
						vinculo.setCodigoClaseEmpleado(rs.getString("CODIGO_CLASE_EMPLEADO"));
						vinculo.setNombreClaseEmpleado(rs.getString("NOMBRE_CLASE_EMPLEADO"));

						return vinculo;
					}
				});
	}

}
