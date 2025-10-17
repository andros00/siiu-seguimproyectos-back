package seguimproyectos_back.service.participante.vinculo;

import java.util.List;

import seguimproyectos_back.controller.participante.vinculo.UdeaException;
import seguimproyectos_back.model.participante.VinculoParticipanteDTO;

public interface VinculoParticipanteService {

	List<VinculoParticipanteDTO> consultarVinculoParticipanteByIdentificaion(String indentificacion)
			throws UdeaException;

}
