package seguimproyectos_back.service.participante;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.participante.ParticipanteDTO;

public interface ParticipanteService {
	List<ParticipanteDTO> actualizarParticipante(ParticipanteDTO participante) throws UdeaException;
}
