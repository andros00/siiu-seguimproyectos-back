package seguimproyectos_back.model.compromiso;

import java.util.Date;

import lombok.Data;

@Data
public class CompromisoFechaRequest {
	
	private Long id;
    private Date nuevaFecha;
    private String usuario;

}
