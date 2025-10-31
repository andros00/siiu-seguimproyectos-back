package seguimproyectos_back.model.participante;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ParticipanteDTO {
	
	
    @NotNull(message = "El identificador del participante es obligatorio para la actualización")
    private Integer identificador;

    @NotBlank(message = "El proyecto es obligatorio")
    private String proyecto;

    @NotBlank(message = "La persona natural es obligatoria")
    private String personaNatural;

    @Size(max = 1, message = "El selector de persona debe tener solo un carácter")
    private String selectorPersona;

    @NotBlank(message = "La vinculación UdeA es obligatoria")
    private String vinculacionUdea;

    private String vinculacionTipo;
    private String vinculacionClase;

    @Min(value = 0, message = "El código del programa apoyado no puede ser negativo")
    private Integer codProgramaApoyado;

    @Min(value = 0, message = "El valor de anónimo debe ser 0 o 1")
    @Max(value = 1, message = "El valor de anónimo debe ser 0 o 1")
    private Integer anonimo;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime  fechaInicio;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime  fechaFin;

    @NotNull(message = "El rol del participante en el proyecto es obligatorio")
    private Integer rolParticipanteProyecto;

    private String institucion;
    private String selectorInstitucion;

    @Min(value = 0, message = "El grupo no puede ser negativo")
    private Integer grupo;

    @DecimalMin(value = "0.0", inclusive = true, message = "La dedicación en meses no puede ser negativa")
    private BigDecimal dedicacionMeses;

    @DecimalMin(value = "0.0", inclusive = true, message = "La dedicación en horas no puede ser negativa")
    private BigDecimal dedicacionHoras;

    @DecimalMin(value = "0.0", inclusive = true, message = "La dedicación en meses plan no puede ser negativa")
    private BigDecimal dedicacionMesesPlan;

    @DecimalMin(value = "0.0", inclusive = true, message = "La dedicación en horas plan no puede ser negativa")
    private BigDecimal dedicacionHorasPlan;

    @Min(value = 0, message = "El porcentaje de beneficios no puede ser negativo")
    @Max(value = 100, message = "El porcentaje de beneficios no puede ser mayor a 100")
    private Integer porcentajeBeneficios;

    private String funcion;
    private String observacion;

    @NotBlank(message = "El usuario que actualiza es obligatorio")
    private String usuarioActualiza;

    @NotBlank(message = "El nombre del participante es obligatorio")
    private String nombre;

    @Email(message = "El correo electrónico no es válido")
    private String correo;

    private Integer notaAclaratoria;
    private String notaAclaratoriaGeneral;
    private String tipoContrato;
    private String detalleContrato;
    private String nombreProgramaExterno;
	
	
	
//	private Integer anonimo;
//	private Integer codProgramaApoyado;
//	private BigDecimal dedicacionHoras;
//	private BigDecimal dedicacionHorasPlan;
//	private BigDecimal dedicacionMeses;
//	private BigDecimal dedicacionMesesPlan;
//	private String detalleContrato;
//	private String funcion;
//	private Integer grupo;
//	private Integer identificador;
//	private String institucion;
//	private String nombreProgramaExterno;
//	private Integer notaAclaratoria;
//	private String notaAclaratoriaGeneral;
//	private String observacion;
//	private String personaNatural;
//	private Integer porcentajeBeneficios;
//	private Integer rolParticipanteProyecto;
//	private String selectorPersona;
//	private String tipoContrato;
//	private String usuarioActualiza;
//	private String vinculacionClase;
//	private String vinculacionTipo;
//	private String vinculacionUdea;
//
//	private String proyecto;
//	private Date fechaInicio;
//	private Date fechaFin;
//	private String selectorInstitucion;
//	private String nombre;
//	private String correo;
	
	

}
