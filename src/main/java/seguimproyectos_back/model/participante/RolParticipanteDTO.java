package seguimproyectos_back.model.participante;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolParticipanteDTO {

	private Integer identificador;
	private String nombre;
	private Integer tipoProyecto;
	private Integer participaBeneficios;
	private Integer apoyaProgramaAcad;
	private String tipoProgramaApoyado;
	private String descripcion;
	private LocalDate inicioVigencia;
	private LocalDate finVigencia;
	private String registrador;
	private String selectorRegistrador;
	private LocalDate fechaUltimoCambio;
	private Integer esInvestigadorPrincipal;
	private Integer exclusivoUdea;
	private Long projectParticipantIdentificador;
	private Long rolParticipanteProyecto;

}
