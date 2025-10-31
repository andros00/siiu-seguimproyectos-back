package seguimproyectos_back.service.participante;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.participante.ParticipanteDTO;

public interface ParticipanteService {
	ParticipanteDTO actualizarParticipante(ParticipanteDTO participante) throws UdeaException;
}
