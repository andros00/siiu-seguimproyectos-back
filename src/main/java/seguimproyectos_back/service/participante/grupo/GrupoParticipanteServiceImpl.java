package seguimproyectos_back.service.participante.grupo;

import java.util.List;

import seguimproyectos_back.dao.participante.grupo.GrupoParticipanteDao;
import seguimproyectos_back.model.participante.grupo.GrupoParticipanteDTO;

public class GrupoParticipanteServiceImpl implements GrupoParticipanteService {

	private final GrupoParticipanteDao repository;

	public GrupoParticipanteServiceImpl(GrupoParticipanteDao repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<GrupoParticipanteDTO> consultarGrupoParticipanteByIdentificaion(String identificacion)
			throws UdeaException {
		return repository.consultarGrupoParticipante(identificacion);
	}

}
