package seguimproyectos_back.service.estadosproyecto;

import java.util.List;

import org.springframework.stereotype.Service;

import seguimproyectos_back.dao.EstadoProyectoDao;
import seguimproyectos_back.model.EstadoProyectoDTO;
import seguimproyectos_back.service.projectType.UdeaException;

@Service
public class EstadoProyectoServiceImpl implements EstadoProyectoService {

	
	private final EstadoProyectoDao repository;

	public ProjectTypeServiceImpl(EstadoProyectoDao repository) {
		this.repository = repository;
	}

	@Override
	public List<EstadoProyectoDTO> getAll(Integer skip, Integer limit) throws UdeaException {

		return repository.getAll();

	
}
