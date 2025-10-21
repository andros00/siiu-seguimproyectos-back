package seguimproyectos_back.service.participante.grupo;

import java.util.List;

import seguimproyectos_back.model.participante.grupo.GrupoParticipanteDTO;

public interface GrupoParticipanteService {

	List<GrupoParticipanteDTO> consultarGrupoParticipanteByIdentificaion(String identificacion) throws UdeaException;

}
