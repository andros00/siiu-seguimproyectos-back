package seguimproyectos_back.service.estadosproyecto;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.dao.EstadoProyectoDao;
import seguimproyectos_back.model.EstadoProyectoDTO;

@Service
public class EstadoProyectoServiceImpl implements EstadoProyectoService {

	
	private final EstadoProyectoDao repository;

	public EstadoProyectoServiceImpl(EstadoProyectoDao repository) {
		this.repository = repository;
	}

	@Override
	public List<EstadoProyectoDTO> getAll() throws UdeaException {

		return repository.getAll();

	}
}
