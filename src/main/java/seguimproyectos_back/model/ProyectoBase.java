package seguimproyectos_back.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class ProyectoBase implements Serializable {

	private static final long serialVersionUID = 5047775266466782167L;

    private String codigo;
    private String estado;
    private Long convocatoria;
    private Long procesoSeleccion;
    private String nombreCorto;
    private String nombreCompleto;
    private String responsable;
    private Long subtipoProyecto;
    private String palabrasClaves;
    private Long duracion;


//    private Long modalidadConvocatoria;
//    private Long etapaActual;
//    private Long instanciaAdmtivaActual;
//    private Long centroGestion;
//    private Date fechaEnvioCentro;
//    private String selectorResponsable;
//    private String seccional;
//    private String selectorSeccional;
//    private Date fechaAprobacionRechazo;
//    private Date fechaRegistro;
//    private String lugarEjecucion;
//    private String moneda;
//    private Long pendienteAjustePpto;
//    private String periodoCronograma;
}