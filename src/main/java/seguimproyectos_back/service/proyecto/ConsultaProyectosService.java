package seguimproyectos_back.service.proyecto;

import java.util.List;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.ProyectoDTO;

public interface ConsultaProyectosService {
	
	List<ProyectoDTO> consultarProyecto(ProyectoDTO proyecto) throws UdeaException;
	
}
