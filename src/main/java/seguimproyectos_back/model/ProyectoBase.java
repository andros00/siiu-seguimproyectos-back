package seguimproyectos_back.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class ProyectoBase implements Serializable {

	private static final long serialVersionUID = 5047775266466782167L;

    // Columna: CODIGO
    private String codigo;

    // Columna: CONVOCATORIA
    private Long convocatoria;

    // Columna: MODALIDAD_CONVOCATORIA
    private Long modalidadConvocatoria;

    // Columna: PROCESO_SELECCION
    private Long procesoSeleccion;

    // Columna: SUBTIPO_PROYECTO
    private Long subtipoProyecto;

    // Columna: ETAPA_ACTUAL
    private Long etapaActual;

    // Columna: INSTANCIA_ADMTIVA_ACTUAL
    private Long instanciaAdmtivaActual;

    // Columna: CENTRO_GESTION
    private Long centroGestion;

    // Columna: FECHA_ENVIO_CENTRO
    private Date fechaEnvioCentro;

    // Columna: RESPONSABLE
    private String responsable;

    // Columna: SELECTOR_RESPONSABLE
    private String selectorResponsable;

    // Columna: SECCIONAL
    private String seccional;

    // Columna: SELECTOR_SECCIONAL
    private String selectorSeccional;

    // Columna: ESTADO
    private String estado;

    // Columna: FECHA_APROBACION_RECHAZO
    private Date fechaAprobacionRechazo;

    // Columna: FECHA_REGISTRO
    private Date fechaRegistro;

    // Columna: NOMBRE_CORTO
    private String nombreCorto;

    // Columna: NOMBRE_COMPLETO
    private String nombreCompleto;

    // Columna: PALABRAS_CLAVES
    private String palabrasClaves;

    // Columna: DURACION
    private Long duracion;

    // Columna: LUGAR_EJECUCION
    private String lugarEjecucion;

    // Columna: MONEDA
    private String moneda;

    // Columna: TASA_CAMBIO_REF

    // Columna: PENDIENTE_AJUSTE_PPTO
    private Long pendienteAjustePpto;

    // Columna: PERIODO_CRONOGRAMA
    private String periodoCronograma;
}