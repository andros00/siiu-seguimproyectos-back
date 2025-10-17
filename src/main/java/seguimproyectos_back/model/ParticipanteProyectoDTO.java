package seguimproyectos_back.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParticipanteProyectoDTO {
	private BigDecimal identificador;
	private String proyecto;
	private String personaNatural;
	private String selectorPersona;
	private String vinculacionUdea;
	private String vinculacionTipo;
	private String vinculacionClase;
	private Long codProgramaApoyado;
	private Long anonimo;
	private Date fechaInicio;
	private Date fechaFin;
	private Long rolParticipanteProyecto;
	private String institucion;
	private String selectorInstitucion;
	private BigDecimal grupo;
	private Long dedicacionMeses;
	private Long dedicacionHoras;
	private Long dedicacionMesesPlan;
	private Long dedicacionHorasPlan;
	private Long porcentajeBeneficios;
	private String funcion;
	private String observacion;
	private String usuarioCrea;
	private Date fechaCrea;
	private String usuarioActualiza;
	private Date fechaActualiza;
	private Long codFaculProgApoy;
	private Long porcentajeProgAcad;
	private String rolParticipante;
	private String participaBeneficios;
	private String detalleContrato;
	private String tipoContrato;
	private String nombreCortoGrupo;
	private String nombrePersona;
	private String nombreProgramaExterno;
	private String esInvestigadorPrinci;
	private String dedicacionNN;
	private String nombreGrupo;
	private int esInvestigadorPrincipal;
		
}
