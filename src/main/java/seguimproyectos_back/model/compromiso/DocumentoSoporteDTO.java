package seguimproyectos_back.model.compromiso;

import java.sql.Blob;

import org.apache.tomcat.jni.FileInfo;

import lombok.Data;

@Data
public class DocumentoSoporteDTO {

	private transient FileInfo currentFile;
	private int fileProgress;
	private Blob archivo;
	private String usuarioCreaNombre;
	private Long idSolicitud;
	private String mimetype;
	private boolean actualizacion;
	private String subSerieDocumento;
	private String proyectoCodigo;
	private String mensajeError;

	private enum TipoMensaje {
		ERROR, INFO, FATAL, WARNING
	}
}
