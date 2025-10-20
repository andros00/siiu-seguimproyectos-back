package seguimproyectos_back.service.participante.proyecto;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.participante.proyecto.ParticipanteProyectoDao;
import seguimproyectos_back.model.ParticipanteProyectoDTO;

@Service
public class ParticipanteProyectoServiceImpl implements ParticipanteProyectoService {

	private final ParticipanteProyectoDao repository;

	public ParticipanteProyectoServiceImpl(ParticipanteProyectoDao repository) {
		this.repository = repository;
	}

	@Override
	public List<ParticipanteProyectoDTO> consultarParticipanteProyectoXCodigo(String codigoProyecto)
			throws UdeaException {
		return repository.consultarParticipantes(codigoProyecto);

	}

	@Override
	public ParticipanteProyectoDTO consultarParticipanteXIdentificacion(String identificacion) throws UdeaException {

		return repository.consultarParticipantePorId(identificacion);

	}

}
