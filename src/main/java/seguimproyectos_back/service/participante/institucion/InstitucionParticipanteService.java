package seguimproyectos_back.service.participante.institucion;

import java.util.List;

import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteDTO;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteRequest;

public interface InstitucionParticipanteService {

	List<InstitucionParticipanteDTO> consultarInstitucionParticipanteByIdentificaion(InstitucionParticipanteRequest institucionParticipante)
			throws UdeaException;

}
