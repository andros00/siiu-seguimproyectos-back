package seguimproyectos_back.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstadoProyectoDTO {

	@NotNull(message = "El identificador del tipo de proyecto no puede ser nulo.")
	private String id;

	@NotBlank(message = "El nombre del tipo de proyecto no puede estar vacío.")
	@Size(min = 1, max = 200, message = "El nombre del tipo de proyecto debe tener entre 1 y 200 caracteres.")
	private String shortName;

	public EstadoProyectoDTO(@NotNull(message = "El identificador del tipo de proyecto no puede ser nulo.") String id,
			@NotBlank(message = "El nombre del tipo de proyecto no puede estar vacío.") @Size(min = 1, max = 200, message = "El nombre del tipo de proyecto debe tener entre 1 y 200 caracteres.") String shortName) {
		super();
		this.id = id;
		this.shortName = shortName;
	}

	public EstadoProyectoDTO() {
	}
	
	

}
