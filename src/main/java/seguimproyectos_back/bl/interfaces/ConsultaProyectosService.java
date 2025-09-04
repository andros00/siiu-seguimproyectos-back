package seguimproyectos_back.bl.interfaces;

import java.util.List;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.Proyecto;

public interface ConsultaProyectosService {
	
	List<Proyecto> consultarProyecto(Proyecto proyecto) throws UdeaException;
	
}
