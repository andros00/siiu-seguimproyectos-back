package seguimproyectos_back.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.ParticipanteProyectoDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalRequest;

@Repository
public class PersonaNaturalDao {

	private final JdbcTemplate jdbcTemplate;

	public PersonaNaturalDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return valor.trim();
	}

	public List<PersonaNaturalDTO> consultarPersona(String identificacion) throws UdeaException {
		String sql = "SELECT * from TABLE (gene_consultas.buscarpersonanatural(?,''))";

		return jdbcTemplate.query(
				sql, new Object[] { formatSqlLike(identificacion),
						},
				new RowMapper<PersonaNaturalDTO>() {
					@Override
					public PersonaNaturalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						PersonaNaturalDTO p = new PersonaNaturalDTO();

						// Identificación
						p.setTipoIdentificacion(rs.getString("TIPO_IDENTIFICACION"));
						p.setIdentificacion(rs.getString("IDENTIFICACION"));
						p.setIdentificacionLdap(rs.getString("IDENTIFICACION_LDAP"));

						// Información personal
						p.setNombrePila(rs.getString("NOMBRE_PILA"));
						p.setApellido1(rs.getString("APELLIDO1"));
						p.setApellido2(rs.getString("APELLIDO2"));

						// Contacto
						p.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
						p.setDireccion(rs.getString("DIRECCION"));
						p.setTelefono(rs.getString("TELEFONO"));

						// Ubicación geográfica
						p.setContinente(rs.getLong("CONTINENTE"));
						p.setPais(rs.getLong("PAIS"));
						p.setDepartamento(rs.getLong("DEPARTAMENTO"));
						p.setMunicipio(rs.getLong("MUNICIPIO"));

						// Estado temporal
						p.setTemporal(rs.getLong("TEMPORAL"));

						return p;
					}
				});
	}

}
