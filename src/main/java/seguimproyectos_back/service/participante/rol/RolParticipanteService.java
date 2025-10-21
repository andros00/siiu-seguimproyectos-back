package seguimproyectos_back.service.participante.rol;

import java.util.List;

import seguimproyectos_back.model.participante.RolParticipanteDTO;

public interface RolParticipanteService {

	List<RolParticipanteDTO> rolParticipanteAll() throws UdeaException;

}
