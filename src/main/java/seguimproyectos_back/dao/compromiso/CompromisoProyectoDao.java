package seguimproyectos_back.dao.compromiso;

import java.sql.Types;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.compromiso.CompromisoCentroDTO;
import seguimproyectos_back.model.compromiso.CompromisoFechaRequest;
import seguimproyectos_back.model.compromiso.CompromisoProyectoDTO;

@Repository
public class CompromisoProyectoDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public CompromisoProyectoDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insert(CompromisoProyectoDTO compromiso) throws UdeaException {
		return jdbcTemplate.queryForObject("SELECT SIIU_COMPROMISO_POR_PROY_CRUD.SP_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { compromiso.getCompromiso(), compromiso.getProyecto(), compromiso.getAsumido(),
						compromiso.getResultadoAutomatico(), compromiso.getDescripcionPropio(),
						compromiso.getComentario(), compromiso.getFechaEstimada(), compromiso.getTipoCompromiso(),
						compromiso.getUsuarioCrea() },
				new int[] { Types.INTEGER, Types.CHAR, Types.INTEGER, Types.CHAR, Types.CHAR, Types.CHAR, Types.DATE,
						Types.INTEGER, Types.CHAR },
				Integer.class);
	}

	public int update(CompromisoProyectoDTO compromiso) throws UdeaException {
		return jdbcTemplate.queryForObject(
				"SELECT SIIU_COMPROMISO_POR_PROY_CRUD.SP_UPDATE00(?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { compromiso.getDescripcionPropio(), compromiso.getComentario(),
						compromiso.getFechaEstimada(), compromiso.getFechaReal(), compromiso.getActaNro(),
						compromiso.getActaFecha(), compromiso.getEstado(), compromiso.getUsuarioModifica(),
						compromiso.getIdentificador() },
				new int[] { Types.CHAR, Types.CHAR, Types.DATE, Types.DATE, Types.CHAR, Types.DATE, Types.CHAR,
						Types.CHAR, Types.INTEGER },
				Integer.class);
	}

	public int actualizarFechaEstimada(CompromisoFechaRequest compromisoFecha) throws UdeaException {

		final String sql = "{ ? = call SIIU_COMPROMISO_POR_PROY_CRUD.SP_UPDATE03("
				+ String.join(",", Collections.nCopies(3, "?")) + ") }";

		return jdbcTemplate.execute(sql, (CallableStatementCallback<Integer>) cs -> {

			cs.registerOutParameter(1, Types.NUMERIC);

			// 1–6: Campos básicos de vinculación
			cs.setLong(2, compromisoFecha.getId());
			cs.setDate(3, new java.sql.Date(compromisoFecha.getNuevaFecha().getTime()));
			cs.setString(4, formatSqlLike(compromisoFecha.getUsuario()));

			cs.execute();
			return cs.getInt(1);
		});

	}

	public List<CompromisoProyectoDTO> findAll() {
		return jdbcTemplate.query("SELECT * FROM TABLE(SIIU_COMPROMISO_POR_PROY_CRUD.SP_SELECT)", (rs, rowNum) -> {
			CompromisoProyectoDTO c = new CompromisoProyectoDTO();
			c.setIdentificador(rs.getLong("IDENTIFICADOR"));
			c.setProyecto(rs.getString("PROYECTO"));
			c.setDescripcionPropio(rs.getString("DESCRIPCION_PROPIO"));
			c.setFechaEstimada(rs.getDate("FECHA_ESTIMADA"));
			return c;
		});
	}

	public CompromisoProyectoDTO findById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM TABLE(SIIU_COMPROMISO_POR_PROY_CRUD.SP_SELECT01(?))",
				new Object[] { id }, (rs, rowNum) -> {
					CompromisoProyectoDTO c = new CompromisoProyectoDTO();
					c.setIdentificador(rs.getLong("IDENTIFICADOR"));
					c.setProyecto(rs.getString("PROYECTO"));
					c.setDescripcionPropio(rs.getString("DESCRIPCION_PROPIO"));
					return c;
				});
	}

	public List<CompromisoProyectoDTO> findByProyecto(String codigo) {
		return jdbcTemplate.query("SELECT * FROM TABLE(SIIU_COMPROMISO_POR_PROY_CRUD.SP_SELECT01(?))",
				new Object[] { codigo }, (rs, rowNum) -> {
					CompromisoProyectoDTO c = new CompromisoProyectoDTO();
					c.setIdentificador(rs.getLong("IDENTIFICADOR"));
					c.setProyecto(rs.getString("PROYECTO"));
					c.setDescripcionPropio(rs.getString("DESCRIPCION_PROPIO"));
					c.setComentario(rs.getString("COMENTARIO"));
					c.setTipoCompromiso(rs.getInt("ID_TIPO"));
					c.setFechaEstimada(rs.getDate("FECHA_ESTIMADA"));
					c.setEstado(rs.getString("ESTADO"));
					return c;
				});
	}

	public List<CompromisoCentroDTO> findByCentro(CompromisoCentroDTO filtro) {
		return jdbcTemplate.query("SELECT * FROM TABLE(SIIU_COMPROMISO_POR_PROY_CRUD.SP_SELECT02(?,?,?,?,?,?,?,?))",
				new Object[] { filtro.getCentroId(), filtro.getTipoCompromiso(), filtro.getPalabraClave(),
						filtro.isRegistradoCumplimiento() ? "SI" : "NO", filtro.getProyectoEstado(),
						filtro.getFechaCumplimientoDesde(), filtro.getFechaCumplimientoHasta(),
						filtro.getProyectoCodigo() },
				(rs, rowNum) -> {
					CompromisoCentroDTO c = new CompromisoCentroDTO();
					c.setCentroNombre(rs.getString("PR_INSTANCIA_NOMBRE"));
					c.setProyectoCodigo(rs.getString("PR_CODIGO"));
					c.setProyectoNombre(rs.getString("PR_NOMBRE_CORTO"));
					return c;
				});
	}

	private String formatSqlLike(String valor) {
		if (valor == null || valor.trim().isEmpty() || "%".equals(valor.trim())) {
			return "%";
		}
		return "%" + valor.trim() + "%";
	}

}
