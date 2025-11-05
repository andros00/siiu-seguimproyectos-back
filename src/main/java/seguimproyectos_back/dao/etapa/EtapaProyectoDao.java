package seguimproyectos_back.dao.etapa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.proyecto.etapa.EtapaProyectoDTO;

@Repository
public class EtapaProyectoDao {

    private final JdbcTemplate jdbcTemplate;

    public EtapaProyectoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // ---------------------------------------------------------------
    // INSERT
    // ---------------------------------------------------------------
    public int insert(EtapaProyectoDTO etapa) throws UdeaException {
            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withFunctionName("SIIU_ETAPA_PROYECTO_CRUD.SP_INSERT")
                    .declareParameters(
                            new SqlOutParameter("RETORNO", Types.INTEGER),
                            new SqlParameter("P_NOMBRE", Types.VARCHAR),
                            new SqlParameter("P_DESCRIPCION", Types.VARCHAR),
                            new SqlParameter("P_EJECUCION_PRESUPUESTAL", Types.INTEGER),
                            new SqlParameter("P_DURACION", Types.INTEGER),
                            new SqlParameter("P_INICIO_VIGENCIA", Types.DATE),
                            new SqlParameter("P_FIN_VIGENCIA", Types.DATE),
                            new SqlParameter("P_CODIGO_PROYECTO", Types.VARCHAR),
                            new SqlParameter("P_ORDEN", Types.INTEGER),
                            new SqlParameter("P_CONSECUTIVO", Types.INTEGER),
                            new SqlParameter("P_USUARIO_CREA", Types.VARCHAR)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("P_NOMBRE", etapa.getNombre());
            params.put("P_DESCRIPCION", etapa.getDescripcion());
            params.put("P_EJECUCION_PRESUPUESTAL", etapa.getEjecucionPresupuestal());
            params.put("P_DURACION", etapa.getDuracion());
            params.put("P_INICIO_VIGENCIA", etapa.getInicioVigencia());
            params.put("P_FIN_VIGENCIA", etapa.getFinVigencia());
            params.put("P_CODIGO_PROYECTO", etapa.getCodigoProyecto());
            params.put("P_ORDEN", etapa.getOrden());
            params.put("P_CONSECUTIVO", etapa.getConsecutivo());
            params.put("P_USUARIO_CREA", etapa.getUsuarioCrea());

            Map<String, Object> result = call.execute(params);
            return ((Number) result.get("RETORNO")).intValue();
    }

    // ---------------------------------------------------------------
    // UPDATE
    // ---------------------------------------------------------------
    public int update(EtapaProyectoDTO etapa) throws UdeaException {
            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withFunctionName("SIIU_ETAPA_PROYECTO_CRUD.SP_UPDATE")
                    .declareParameters(
                            new SqlOutParameter("RETORNO", Types.INTEGER),
                            new SqlParameter("P_NOMBRE", Types.VARCHAR),
                            new SqlParameter("P_DESCRIPCION", Types.VARCHAR),
                            new SqlParameter("P_EJECUCION_PRESUPUESTAL", Types.INTEGER),
                            new SqlParameter("P_DURACION", Types.INTEGER),
                            new SqlParameter("P_INICIO_VIGENCIA", Types.DATE),
                            new SqlParameter("P_FIN_VIGENCIA", Types.DATE),
                            new SqlParameter("P_CODIGO_PROYECTO", Types.VARCHAR),
                            new SqlParameter("P_ORDEN", Types.INTEGER),
                            new SqlParameter("P_CONSECUTIVO", Types.INTEGER),
                            new SqlParameter("P_USUARIO_ACTUALIZA", Types.VARCHAR),
                            new SqlParameter("P_IDENTIFICADOR", Types.NUMERIC)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("P_NOMBRE", etapa.getNombre());
            params.put("P_DESCRIPCION", etapa.getDescripcion());
            params.put("P_EJECUCION_PRESUPUESTAL", etapa.getEjecucionPresupuestal());
            params.put("P_DURACION", etapa.getDuracion());
            params.put("P_INICIO_VIGENCIA", etapa.getInicioVigencia());
            params.put("P_FIN_VIGENCIA", etapa.getFinVigencia());
            params.put("P_CODIGO_PROYECTO", etapa.getCodigoProyecto());
            params.put("P_ORDEN", etapa.getOrden());
            params.put("P_CONSECUTIVO", etapa.getConsecutivo());
            params.put("P_USUARIO_ACTUALIZA", etapa.getUsuarioActualiza());
            params.put("P_IDENTIFICADOR", etapa.getIdentificador());

            Map<String, Object> result = call.execute(params);
            return ((Number) result.get("RETORNO")).intValue();
    }

    // ---------------------------------------------------------------
    // DELETE
    // ---------------------------------------------------------------
    public int delete(Long identificador) throws UdeaException {
            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withFunctionName("SIIU_ETAPA_PROYECTO_CRUD.SP_DELETE")
                    .declareParameters(
                            new SqlOutParameter("RETORNO", Types.INTEGER),
                            new SqlParameter("P_IDENTIFICADOR", Types.NUMERIC)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("P_IDENTIFICADOR", identificador);
            Map<String, Object> result = call.execute(params);

            return ((Number) result.get("RETORNO")).intValue();
    }

    // ---------------------------------------------------------------
    // DELETE por código proyecto
    // ---------------------------------------------------------------
    public int borrarEtapas(String codigoProyecto) throws UdeaException {
            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withFunctionName("SIIU_ETAPA_PROYECTO_CRUD.SP_DELETE2")
                    .declareParameters(
                            new SqlOutParameter("RETORNO", Types.INTEGER),
                            new SqlParameter("P_CODIGO_PROYECTO", Types.VARCHAR)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("P_CODIGO_PROYECTO", codigoProyecto);
            Map<String, Object> result = call.execute(params);

            return ((Number) result.get("RETORNO")).intValue();
    }

    // ---------------------------------------------------------------
    // CONSULTA POR CÓDIGO PROYECTO
    // ---------------------------------------------------------------
    public List<EtapaProyectoDTO> findByCodigoProyecto(String codigoProyecto) throws UdeaException {
            String sql = "SELECT * FROM TABLE(SIIU_ETAPA_PROYECTO_CRUD.SP_SELECT01(?))";
            return jdbcTemplate.query(sql, new Object[]{codigoProyecto}, new EtapaMapper());
    }

    // ---------------------------------------------------------------
    // CONSULTA EJECUCIÓN PRESUPUESTAL
    // ---------------------------------------------------------------
    public EtapaProyectoDTO findEjecucionPresupuestal(String codigoProyecto) throws UdeaException {
            String sql = "SELECT * FROM TABLE(SIIU_ETAPA_PROYECTO_CRUD.SP_SELECT02(?))";
            List<EtapaProyectoDTO> list = jdbcTemplate.query(sql, new Object[]{codigoProyecto}, (rs, rowNum) -> {
                EtapaProyectoDTO e = new EtapaProyectoDTO();
                e.setEjecucionPresupuestal(rs.getLong("EJECUCION_PRESUPUESTAL"));
                return e;
            });
            return list.isEmpty() ? null : list.get(0);
    }

    // ---------------------------------------------------------------
    // CONSULTA DESDE FECHA REFERENCIA
    // ---------------------------------------------------------------
    public List<EtapaProyectoDTO> consultarEtapasDesdeFecha(String codigoProyecto, Date fechaReferencia)
            throws UdeaException {
            String sql = "SELECT * FROM TABLE(SIIU_ETAPA_PROYECTO_CRUD.SP_SELECT03(?,?))";
            return jdbcTemplate.query(sql, new Object[]{codigoProyecto, new java.sql.Date(fechaReferencia.getTime())}, new EtapaMapper());
    }

    // ---------------------------------------------------------------
    // RowMapper para EtapaProyectoDTO
    // ---------------------------------------------------------------
    private static class EtapaMapper implements RowMapper<EtapaProyectoDTO> {
        @Override
        public EtapaProyectoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            EtapaProyectoDTO etapa = new EtapaProyectoDTO();
            etapa.setIdentificador(rs.getLong("IDENTIFICADOR"));
            etapa.setNombre(rs.getString("NOMBRE"));
            etapa.setDescripcion(rs.getString("DESCRIPCION"));
            etapa.setEjecucionPresupuestal(rs.getLong("EJECUCION_PRESUPUESTAL"));
            etapa.setDuracion(rs.getInt("DURACION"));
            etapa.setInicioVigencia(rs.getDate("INICIO_VIGENCIA"));
            etapa.setFinVigencia(rs.getDate("FIN_VIGENCIA"));
            etapa.setCodigoProyecto(rs.getString("CODIGO_PROYECTO"));
            etapa.setOrden(rs.getInt("ORDEN"));
            etapa.setConsecutivo(rs.getInt("CONSECUTIVO"));
            etapa.setUsuarioCrea(rs.getString("USUARIO_CREA"));
            etapa.setFechaCrea(rs.getDate("FECHA_CREA"));
            etapa.setUsuarioActualiza(rs.getString("USUARIO_ACTUALIZA"));
            etapa.setFechaActualiza(rs.getDate("FECHA_ACTUALIZA"));
            etapa.setEjecucionPresupuestalStr(etapa.getEjecucionPresupuestal() == 1 ? "Si" : "No");
            return etapa;
        }
    }
}
