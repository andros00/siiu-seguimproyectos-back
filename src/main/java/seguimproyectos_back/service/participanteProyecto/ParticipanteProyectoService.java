package seguimproyectos_back.service.participanteProyecto;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.ParticipanteProyectoDTO;

public interface ParticipanteProyectoService {
	List<ParticipanteProyectoDTO> consultarParticipanteProyectoXCodigo (String codigoProyecto) throws UdeaException;

}
