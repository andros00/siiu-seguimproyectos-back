package seguimproyectos_back.service.participante;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.participante.ParticipanteDao;
import seguimproyectos_back.model.participante.ParticipanteDTO;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

	private final ParticipanteDao repository;

	public ParticipanteServiceImpl(ParticipanteDao repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<ParticipanteDTO> actualizarParticipante(ParticipanteDTO participante) throws UdeaException {
		return repository.actualizarParticipante(participante);
	}

}
