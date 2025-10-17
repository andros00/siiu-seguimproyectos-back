package seguimproyectos_back.model.personanatural;

import lombok.Data;

@Data
public class PersonaNaturalRequest {

	private String identificacion;
	private String nombrePersona;
	private String correo;

}
