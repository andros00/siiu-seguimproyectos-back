package seguimproyectos_back.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdministrativeCenterDTO {

	@NotNull(message = "El identificador del centro administrativo no puede ser nulo.")
	private Long id;
	@NotNull(message = "El nombre del centro administrativo no puede ser nulo.")
	private String shortName;
}
