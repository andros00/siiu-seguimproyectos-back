package seguimproyectos_back.service.participante.proyecto;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.ParticipanteProyectoDTO;

public interface ParticipanteProyectoService {
	
	List<ParticipanteProyectoDTO> consultarParticipanteProyectoXCodigo(String codigoProyecto) throws UdeaException;

	ParticipanteProyectoDTO consultarParticipanteXIdentificacion(String identificacion) throws UdeaException;
}
