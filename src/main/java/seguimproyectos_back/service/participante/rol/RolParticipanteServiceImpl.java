package seguimproyectos_back.service.participante.rol;

import java.util.List;

import org.springframework.stereotype.Service;

import seguimproyectos_back.dao.participante.rol.RolParticipanteDao;
import seguimproyectos_back.model.participante.RolParticipanteDTO;

@Service
public class RolParticipanteServiceImpl implements RolParticipanteService {

	private RolParticipanteDao repository;

	@Override
	public List<RolParticipanteDTO> rolParticipanteAll() throws UdeaException {
		return repository.rolParticipantes();
	}

}
