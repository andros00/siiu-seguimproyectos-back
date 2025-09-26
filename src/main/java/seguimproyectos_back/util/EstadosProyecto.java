package seguimproyectos_back.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class EstadosProyecto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static final String ACTUALIZADO = "actualizado";
    public static final String APLAZADO = "aplazado";
    public static final String APROBADO = "aprobado";
    public static final String ATRASADO = "atrasado";
    public static final String AVALADO = "avalado";
    public static final String CANCELADO = "cancelado";
    public static final String ENVIADO_CENTRO = "enCentro";
    public static final String EN_EJECUCION = "en_ejecucion";
    public static final String EN_ESCRITURA = "escritura";
    public static final String FINALIZADO = "finalizado";
    public static final String FINALIZADO_EVALUADO = "fin_eval";
    public static final String FINALIZADO_PENDIENTE_COMPROMISOS = "fin_pend";
    public static final String LIQUIDADO = "liquidado";
    public static final String NO_PROCESADO = "No procesado";
    public static final String PENDIENTE_ACTUALIZACION = "pendactual";
    public static final String PENDIENTE_APLAZAMIENTO = "pend_aplazar";
    public static final String PENDIENTE_CANCELAR = "pend_cancelar";
    public static final String PENDIENTE_CIENTIFICAMENTE = "pendcient";
    public static final String PENDIENTE_FIN_COMPROMISOS_INC = "pend_fin_comp_inc";
    public static final String PENDIENTE_PRORROGA = "pend_proga";
    public static final String PENDIENTE_SUSPENSION = "pendiente_suspension";
    public static final String PENDIENTE_TECNICAMENTE = "pendtec";
    public static final String PRELIQUIDADO = "preliquid";
    public static final String RECHAZADO = "rechazado";
    public static final String SUSPENDIDO = "suspendido";
    public static final String VALIDADO_CIENTIFICAMENTE = "validcient";
    public static final String VALIDADO_TECNICAMENTE = "validtec";
    public static final String EN_LISTA_ELEGIBLES = "elegible";
    private static final Map<String, String[]> estadosSiguientes = new HashMap<String, String[]>();
    private static final Map<String, String> estadosNombres = new HashMap<String, String>();


    static {
        // Asociar estados posteriores a cada estado.
        estadosSiguientes.put(ACTUALIZADO, new String[]{});
        estadosSiguientes.put(APLAZADO, new String[]{});
        estadosSiguientes.put(APROBADO, new String[]{NO_PROCESADO, PENDIENTE_PRORROGA, EN_EJECUCION});
        estadosSiguientes.put(ATRASADO, new String[]{FINALIZADO});
        estadosSiguientes.put(AVALADO, new String[]{});
        estadosSiguientes.put(CANCELADO, new String[]{});
        estadosSiguientes.put(ENVIADO_CENTRO, new String[]{});
        estadosSiguientes.put(EN_EJECUCION, new String[]{SUSPENDIDO, CANCELADO});
        estadosSiguientes.put(EN_ESCRITURA, new String[]{EN_ESCRITURA});
        estadosSiguientes.put(FINALIZADO, new String[]{FINALIZADO_EVALUADO, LIQUIDADO});
        estadosSiguientes.put(FINALIZADO_EVALUADO, new String[]{LIQUIDADO});
        estadosSiguientes.put(FINALIZADO_PENDIENTE_COMPROMISOS, new String[]{
                    FINALIZADO_PENDIENTE_COMPROMISOS,
                    ATRASADO,
                    FINALIZADO
                });
        estadosSiguientes.put(LIQUIDADO, new String[]{});
        estadosSiguientes.put(NO_PROCESADO, new String[]{});
        estadosSiguientes.put(PENDIENTE_ACTUALIZACION, new String[]{});
        estadosSiguientes.put(PENDIENTE_APLAZAMIENTO, new String[]{APLAZADO, APROBADO});
        estadosSiguientes.put(PENDIENTE_CANCELAR, new String[]{CANCELADO, EN_EJECUCION});
        estadosSiguientes.put(PENDIENTE_CIENTIFICAMENTE, new String[]{});
        estadosSiguientes.put(PENDIENTE_FIN_COMPROMISOS_INC, new String[]{});
        estadosSiguientes.put(PENDIENTE_PRORROGA, new String[]{EN_EJECUCION, ATRASADO});
        estadosSiguientes.put(PENDIENTE_SUSPENSION, new String[]{SUSPENDIDO, EN_EJECUCION});
        estadosSiguientes.put(PENDIENTE_TECNICAMENTE, new String[]{});
        estadosSiguientes.put(PRELIQUIDADO, new String[]{});
        estadosSiguientes.put(RECHAZADO, new String[]{});
        estadosSiguientes.put(SUSPENDIDO, new String[]{EN_EJECUCION});
        estadosSiguientes.put(VALIDADO_TECNICAMENTE, new String[]{});
        estadosSiguientes.put(VALIDADO_CIENTIFICAMENTE, new String[]{});
        estadosSiguientes.put(EN_LISTA_ELEGIBLES, new String[]{});
        // Asociación de nombres descriptivos para cada código de estado.
        estadosNombres.put(ACTUALIZADO, "Actualizado");
        estadosNombres.put(APLAZADO, "Aplazado");
        estadosNombres.put(APROBADO, "Aprobado");
        estadosNombres.put(ATRASADO, "Atrasado");
        estadosNombres.put(AVALADO, "Avalado");
        estadosNombres.put(CANCELADO, "Cancelado");
        estadosNombres.put(ENVIADO_CENTRO, "En centro");
        estadosNombres.put(EN_EJECUCION, "En ejecución");
        estadosNombres.put(EN_ESCRITURA, "Escritura");
        estadosNombres.put(FINALIZADO, "Finalizado");
        estadosNombres.put(FINALIZADO_EVALUADO, "Finalizado evaluado");
        estadosNombres.put(FINALIZADO_PENDIENTE_COMPROMISOS, "Finalizado pendiente de compromisos");
        estadosNombres.put(LIQUIDADO, "Liquidado");
        estadosNombres.put(NO_PROCESADO, "No procesado");
        estadosNombres.put(PENDIENTE_ACTUALIZACION, "Pendiente actualización");
        estadosNombres.put(PENDIENTE_APLAZAMIENTO, "Pendiente de aplazamiento");
        estadosNombres.put(PENDIENTE_CANCELAR, "Pendiente por cancelar");
        estadosNombres.put(PENDIENTE_CIENTIFICAMENTE, "Pendiente científicamente");
        estadosNombres.put(PENDIENTE_FIN_COMPROMISOS_INC, "Pendiente de finalización con compromisos incompletos");
        estadosNombres.put(PENDIENTE_PRORROGA, "Pendiente de prórroga");
        estadosNombres.put(PENDIENTE_SUSPENSION, "Pendiente de suspensión");
        estadosNombres.put(PENDIENTE_TECNICAMENTE, "Pendiente técnicamente");
        estadosNombres.put(PRELIQUIDADO, "Pre liquidado");
        estadosNombres.put(RECHAZADO, "Rechazado");
        estadosNombres.put(SUSPENDIDO, "Suspendido");
        estadosNombres.put(VALIDADO_TECNICAMENTE, "Validado técnicamente");
        estadosNombres.put(VALIDADO_CIENTIFICAMENTE, "Validado científicamente");
        estadosNombres.put(EN_LISTA_ELEGIBLES, "En lista de elegibles");

    }

    public static String getEstadoNombre(String estado) {
        return estadosNombres.get(estado);
    }

    public static String[] getCodigos() {
        return (estadosNombres.keySet()).toArray(new String[estadosNombres.size()]);
    }

    public static String[] getSiguientes(String estado) {
        String listaSiguientes[] = estadosSiguientes.get(estado);
        return listaSiguientes.clone();
    }

    private EstadosProyecto() {
        super();
    }
}
