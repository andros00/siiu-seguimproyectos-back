package seguimproyectos_back.model.personanatural;

import lombok.Data;

@Data
public class PersonaNaturalDTO {

	// Identificación
	private String tipoIdentificacion;
	private String identificacion;
	private String identificacionLdap;

	// Información personal
	private String nombrePila;
	private String apellido1;
	private String apellido2;

	// Contacto
	private String correoElectronico;
	private String direccion;
	private String telefono;

	// Ubicación geográfica
	private Long continente;
	private Long pais;
	private Long departamento;
	private Long municipio;

	// Estado temporal
	private Long temporal;
}
