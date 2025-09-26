package seguimproyectos_back.service.estadosproyecto;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.EstadoProyectoDTO;
import seguimproyectos_back.util.EstadosProyecto;

@Service
public class EstadoProyectoServiceImpl implements EstadoProyectoService {

	@Override
	public List<EstadoProyectoDTO> getAll() throws UdeaException {

		return EstadosProyecto.getEstados();

	}
}
