package seguimproyectos_back.service.participanteProyecto;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.ParticipanteProyectoDao;
import seguimproyectos_back.model.ParticipanteProyectoDTO;

@Service
public class ParticipanteProyectoServiceImpl implements ParticipanteProyectoService {

	private final ParticipanteProyectoDao repository;
	
	public ParticipanteProyectoServiceImpl(ParticipanteProyectoDao repository) {
		this.repository = repository;
	}

	@Override
	public List<ParticipanteProyectoDTO> consultarParticipanteProyectoXCodigo(String codigoProyecto) throws UdeaException {
		return repository.consultarParticipantes(codigoProyecto);
		
	}
	

}
