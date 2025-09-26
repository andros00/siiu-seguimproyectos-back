package seguimproyectos_back.service.estadosproyecto;

import java.util.List;

import seguimproyectos_back.model.EstadoProyectoDTO;
import co.edu.udea.utilities.exception.UdeaException;

public interface EstadoProyectoService {


	List<EstadoProyectoDTO> getAll() throws UdeaException;
}
