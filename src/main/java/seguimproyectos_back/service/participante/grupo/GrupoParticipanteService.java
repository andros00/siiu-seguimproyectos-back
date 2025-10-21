package seguimproyectos_back.service.participante.grupo;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.participante.grupo.GrupoParticipanteDTO;

public interface GrupoParticipanteService {

	List<GrupoParticipanteDTO> consultarGrupoParticipanteByIdentificaion(String identificacion) throws UdeaException;

}
