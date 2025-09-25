package seguimproyectos_back.service.proyecto;

import java.util.List;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.Proyecto;

public interface ConsultaProyectosService {
	
	List<Proyecto> consultarProyecto(Proyecto proyecto) throws UdeaException;
	
}
