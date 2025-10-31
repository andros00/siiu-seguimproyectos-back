package seguimproyectos_back.model.compromiso;

import java.util.Date;

import lombok.Data;

@Data
public class CompromisoCentroDTO {
	
    // Parámetros de entrada al procedimiento
    private Long centroId;
    private Integer tipoCompromiso;
    private String palabraClave;
    private boolean registradoCumplimiento;
    private String proyectoEstado;
    private Date fechaCumplimientoDesde;
    private Date fechaCumplimientoHasta;
    private String proyectoCodigo;

    // Campos devueltos por la consulta
    private String centroNombre;
    private String proyectoNombre;
    private String compromisoDescripcion;
    private String compromisoEstado;
    private Date compromisoFecha;
    private String responsable;
    private String tipoCompromisoNombre;

}
