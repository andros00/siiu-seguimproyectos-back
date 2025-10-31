package seguimproyectos_back.dao.participante.institucion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteDTO;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteRequest;

@Repository
public class InstitucionParticipanteDao {

	private final JdbcTemplate jdbcTemplate;

	public InstitucionParticipanteDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "";
		}
		return valor.trim();
	}

	public List<InstitucionParticipanteDTO> institucionParticipanteByIdentificacion(
			InstitucionParticipanteRequest institucionParticipante) throws UdeaException {

		String sql = "SELECT * FROM TABLE (GENE_CONSULTAS.BUSCARPERSONAJURIDICA(?,?))";

		return jdbcTemplate.query(sql,
				new Object[] { formatSqlLike(institucionParticipante.getNit()),
						formatSqlLike(institucionParticipante.getNombre()) },
				new RowMapper<InstitucionParticipanteDTO>() {
					@Override
					public InstitucionParticipanteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

						InstitucionParticipanteDTO institucion = new InstitucionParticipanteDTO();

						institucion.setNit(rs.getString("NIT"));
						institucion.setNombreCorto(rs.getString("NOMBRE_CORTO"));
						institucion.setRazonSocial(rs.getString("RAZON_SOCIAL"));
						institucion.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
						institucion.setDireccion(rs.getString("DIRECCION"));
						institucion.setTelefono(rs.getString("TELEFONO"));
						institucion.setFax(rs.getString("FAX"));
						institucion.setTipo(rs.getString("TIPO"));
						institucion.setContinente(rs.getInt("CONTINENTE"));
						institucion.setPais(rs.getInt("PAIS"));
						institucion.setDepartamento(rs.getInt("DEPARTAMENTO"));
						institucion.setMunicipio(rs.getInt("MUNICIPIO"));
						institucion.setTemporal(rs.getInt("TEMPORAL"));
						institucion.setCodigoSap(rs.getString("CODIGO_SAP"));

						return institucion;
					}
				});
	}

}
