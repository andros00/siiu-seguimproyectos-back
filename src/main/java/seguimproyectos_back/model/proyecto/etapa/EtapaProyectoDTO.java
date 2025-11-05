package seguimproyectos_back.model.proyecto.etapa;

import java.util.Date;

import lombok.Data;

@Data
public class EtapaProyectoDTO {

	private Long identificador;
	private String nombre;
	private String descripcion;
	private Long ejecucionPresupuestal;
	private Integer duracion;
	private Date inicioVigencia;
	private Date finVigencia;
	private String codigoProyecto;
	private Integer orden;
	private Integer consecutivo;
	private String usuarioCrea;
	private Date fechaCrea;
	private String usuarioActualiza;
	private Date fechaActualiza;
	private String ejecucionPresupuestalStr;

}
