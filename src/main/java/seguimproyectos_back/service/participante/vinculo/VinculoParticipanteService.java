package seguimproyectos_back.service.participante.vinculo;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.participante.VinculoParticipanteDTO;

public interface VinculoParticipanteService {

	List<VinculoParticipanteDTO> consultarVinculoParticipanteByIdentificaion(String identificacion)
			throws UdeaException;

}
