package seguimproyectos_back.model.participante;

import lombok.Data;

@Data
public class VinculoParticipanteDTO {

	// Identificación del vínculo
	private Long secuenciaVinculacion;

	// Tipo de vinculación
	private String codigoTipoVinculacion;
	private String nombreTipoVinculacion;

	// Clase de empleado
	private String codigoClaseEmpleado;
	private String nombreClaseEmpleado;
}
