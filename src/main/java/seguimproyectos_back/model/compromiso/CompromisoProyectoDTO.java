package seguimproyectos_back.model.compromiso;

import java.util.Date;

import lombok.Data;

@Data
public class CompromisoProyectoDTO {

    private Long identificador;
    private String proyecto;
    private Integer compromiso;
    private Integer asumido;
    private String resultadoAutomatico;
    private String descripcionPropio;
    private String comentario;
    private Date fechaEstimada;
    private Date fechaReal;
    private String actaNro;
    private Date actaFecha;
    private String estado;
    private Integer tipoCompromiso;
    private String usuarioCrea;
    private String usuarioModifica;
}