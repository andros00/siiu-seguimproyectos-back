package seguimproyectos_back.model.compromiso;

import java.util.Date;

import lombok.Data;

@Data
public class CompromisoNotaDTO {

	private Long identificador;
    private Long idCompromisoProyecto;
    private String nota;
    private String usuarioCrea;
    private Date fechaCrea;

}
