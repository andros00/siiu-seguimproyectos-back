package seguimproyectos_back.model;

import lombok.Data;

@Data
public class ActividadProyectoDTO {

	private Long identificador;
	private String proyecto;
	private Integer orden;
	private Integer consecutivo;
	private Integer inicio;
	private Integer fin;
	private String nombre;
	private String detalle;

}
