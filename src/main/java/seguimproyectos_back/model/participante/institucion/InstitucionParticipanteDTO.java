package seguimproyectos_back.model.participante.institucion;

import lombok.Data;

@Data
public class InstitucionParticipanteDTO {

	private String nit;
	private String nombreCorto;
	private String razonSocial;
	private String correoElectronico;
	private String direccion;
	private String telefono;
	private String fax;
	private String tipo;
	private Integer continente;
	private Integer pais;
	private Integer departamento;
	private Integer municipio;
	private Integer temporal;
	private String codigoSap;

}
