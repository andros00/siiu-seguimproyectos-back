package seguimproyectos_back.service.actividadproyecto;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.ActividadProyectoDTO;

public interface ActividadProyectoService {
	
	public List<ActividadProyectoDTO> consultarActividadXProyecto(String codigoProyecto) throws UdeaException;

}
