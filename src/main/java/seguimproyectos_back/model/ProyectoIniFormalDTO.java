package seguimproyectos_back.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ProyectoIniFormalDTO {
	
    public static final String ESTADO_EN_EDICION = "en_edicion";
    public static final String ESTADO_CERRADO = "cerrado";

    private static final List<String> estados = new ArrayList<String>();
    static {
        estados.add(ESTADO_EN_EDICION);
        estados.add(ESTADO_CERRADO);
    }

    // Columna: ID
    private Long id;

    // Columna: CODIGO_PROYECTO
    private String codigoProyecto;

    // Columna: DURACION
    private Long duracion;

    // Columna: FECHA_INICIO
    private java.util.Date fechaInicio;

    // Columna: FECHA_FINALIZACION
    private java.util.Date fechaFinalizacion;

    // Columna: USUARIO_CREA
    private String usuarioCrea;

    // Columna: FECHA_CREA
    private java.util.Date fechaCrea;

    // Columna: USUARIO_MODIFICA
    private String usuarioModifica;

    // Columna: FECHA_MODIFICA
    private java.util.Date fechaModifica;

    // Columna: NOTIFICADO_IF
    private String notificadoIF;

    // Columna: NOTIFICADO_FF
    private String notificadoFF;

    // Columna: NOTIFICADO_PA
    private String notificadoPA;

    // Columna: NOTIFICADO_AR
    private String notificadoAR;

    // Columna: NOTIFICADO_FECHA_PE
    private java.util.Date notificadoFechaPE;

    // Columna: NOTIFICADO_FECHA_TE
    private java.util.Date notificadoFechaTE;

    // Columna: CODIGO_INTERNO
    private String codigoInterno;

    // Columna: ESTADO
    private String estado;

    // Columna: FECHA_APROB_PROY_CODI
    private java.util.Date fechaAprobacionProyCodi;

    // Columna: CODIGO_APROB_ACTA_CODI
    private String codigoAprobacionActaCodi;
    
    // Columna: FECHA_APROBACION_RECHAZO
    private java.util.Date fechaAprobacionRechazo;

    /**
     * Constructor por defecto. Asigna a su miembro estado el valor por defecto "ESTADO_EN_EDICION";
     */
    public ProyectoIniFormalDTO() {
        this.estado = ESTADO_EN_EDICION;
    }

    //------------------------------------------------------------------------------------------------------------------
    // LECTORES (get)/ESCRITORES (set)                                                                            INICIO
    //------------------------------------------------------------------------------------------------------------------

    /**
     * <p>
     * Asigna el estado del inicio formal.<br>
     * Si <code>estado</code> es nulo se asigna el valor EN_EDICION, si no se verifica que <code>estado</code> sea un
     * EN_EDICION o CERRADO y en otro caso se emite una IllegalArgumentException.
     * </p>
     *
     * @param estado
     *     El texto valor del estado. Se recomienda usar los valores predefinidos ESTADO_EN_EDICION y
     *     ESTADO_CERRADO.
     */
    public void setEstado(String estado) {
        if (estado == null) {
            this.estado = ESTADO_EN_EDICION;
        } else if (estados.contains(estado)) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException(getErrorEstado(estado));
        }
    }

    private String getErrorEstado(String estado) {
        StringBuilder mensaje = new StringBuilder(String.format("El valor \"%s\" es inválido como estado. Valores permitidos:", estado));
        for(String valor : estados) {
            mensaje.append(String.format(" \"%s\"", valor));
        }
        mensaje.append(".");
        return mensaje.toString();
    }

}
