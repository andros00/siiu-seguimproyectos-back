package seguimproyectos_back.service.participante.institucion;

import java.util.List;

import org.springframework.stereotype.Service;

import seguimproyectos_back.dao.participante.institucion.InstitucionParticipanteDao;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteDTO;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteRequest;

@Service
public class InstitucionParticipanteServiceImpl implements InstitucionParticipanteService {

	private final InstitucionParticipanteDao repository;

	public InstitucionParticipanteServiceImpl(InstitucionParticipanteDao repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<InstitucionParticipanteDTO> consultarInstitucionParticipanteByIdentificaion(
			InstitucionParticipanteRequest institucionParticipante) throws UdeaException {
		return repository.institucionParticipanteByIdentificaion(institucionParticipante);
	}

}
