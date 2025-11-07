package seguimproyectos_back.dao.investigador.joven;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.investigador.joven.JovenInvestigadorDTO;

@Repository
public class JovenInvestigadorDao {

	private final JdbcTemplate jdbcTemplate;

	public JovenInvestigadorDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return valor.trim();
	}

	public List<JovenInvestigadorDTO> consultarJovenInvestigador(String identificacion) throws UdeaException {

		String sql = "SELECT * FROM TABLE(SIIU_PARTICIPANTE_PROY_CRUD.SP_SELECT11(?))";

		return jdbcTemplate.query(sql, new Object[] { formatSqlLike(identificacion) },
				new RowMapper<JovenInvestigadorDTO>() {
					@Override
					public JovenInvestigadorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

						JovenInvestigadorDTO dto = new JovenInvestigadorDTO();

						dto.setTipoIdentificacion(rs.getString("TIPO_IDENTIFICACION"));
						dto.setIdentificacion(rs.getString("IDENTIFICACION"));
						dto.setLugarExpedicion(rs.getString("LUGAR_EXPEDICION"));
						dto.setApellido1(rs.getString("APELLIDO1"));
						dto.setApellido2(rs.getString("APELLIDO2"));
						dto.setNombrePila(rs.getString("NOMBRE_PILA"));
						dto.setCiudadNacimiento(rs.getString("CIUDAD_NACIMIENTO"));
						dto.setDepartamentoNacimiento(rs.getString("DEPARTAMENTO_NACIMIENTO"));
						dto.setPaisNacimiento(rs.getString("PAIS_NACIMIENTO"));
						dto.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
						dto.setMunicipio(rs.getString("MUNICIPIO"));
						dto.setDireccion(rs.getString("DIRECCION"));
						dto.setBarrio(rs.getString("BARRIO"));
						dto.setEstrato(rs.getString("ESTRATO"));
						dto.setTipoVivienda(rs.getString("TIPO_VIVIENDA"));
						dto.setContactoPrincipal(rs.getString("CONTACTO_PRINCIPAL"));
						dto.setCelular(rs.getString("CELULAR"));
						dto.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
						dto.setBanco(rs.getString("BANCO"));
						dto.setCuenta(rs.getString("CUENTA"));
						dto.setTipoCuenta(rs.getString("TIPO_CUENTA"));
						dto.setFechaModificaParticipante(rs.getDate("FECHA_MODIFICA_PARTICIPANTE"));
						dto.setConfirmado(rs.getString("CONFIRMADO"));
						dto.setConfirmadoConvenio(rs.getString("CONFIRMADO_CONVENIO"));
						dto.setDependencia(rs.getString("DEPENDENCIA"));
						dto.setResumenActividades(rs.getString("RESUMEN_ACTIVIDADES"));
						dto.setIdentificadorParticipante(rs.getLong("IDENTIFICADOR_PARTICIPANTE"));
						dto.setNombreTutor(rs.getString("NOMBRE_TUTOR"));
						dto.setIdentificacionTutor(rs.getString("IDENTIFICACION_TUTOR"));
						dto.setCorreoTutor(rs.getString("CORREO_TUTOR"));
						dto.setContactoTutor(rs.getString("CONTACTO_TUTOR"));
						dto.setPrograma(rs.getString("PROGRAMA"));
						dto.setSemestre(rs.getString("SEMESTRE"));
						dto.setFechaInicioSemestre(rs.getDate("FECHA_INICIO_SEMESTRE"));
						dto.setFechaFinSemestre(rs.getDate("FECHA_FIN_SEMESTRE"));
						dto.setNombreGrupoTutor(rs.getString("NOMBRE_GRUPO_TUTOR"));

						return dto;
					}
				});
	}

}
