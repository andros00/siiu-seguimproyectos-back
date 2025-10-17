package seguimproyectos_back.model.participante;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ParticipanteDTO {

    private Long proyecto;
    private Long personaNatural;
    private String selectorPersona;
    private String vinculacionUdea;
    private String vinculacionTipo;
    private String vinculacionClase;
    private String codProgramaApoyado;
    private String anonimo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String rolParticipanteProyecto;
    private String institucion;
    private String selectorInstitucion;
    private String grupo;
    private Integer dedicacionMeses;
    private Integer dedicacionHoras;
    private Integer dedicacionMesesPlan;
    private Integer dedicacionHorasPlan;
    private Double porcentajeBeneficios;
    private String funcion;
    private String observacion;
    private String usuarioActualiza;
    private String identificador;
    private String nombre;
    private String correo;
    private String notaAclaratoria;
    private String notaAclaratoriaGeneral;
    private String tipoContrato;
    private String detalleContrato;
    private String nombreProgramaExterno;	  

}
