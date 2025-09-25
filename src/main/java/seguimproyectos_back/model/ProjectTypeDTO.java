package seguimproyectos_back.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProjectTypeDTO {

	@NotNull(message = "El identificador del tipo de proyecto no puede ser nulo.")
	private Long id;

	@NotBlank(message = "El nombre del tipo de proyecto no puede estar vacío.")
	@Size(min = 1, max = 200, message = "El nombre del tipo de proyecto debe tener entre 1 y 200 caracteres.")
	private String name;
}