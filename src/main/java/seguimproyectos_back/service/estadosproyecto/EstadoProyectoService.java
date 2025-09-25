package seguimproyectos_back.service.estadosproyecto;

import java.util.List;

import seguimproyectos_back.model.ProjectTypeDTO;
import seguimproyectos_back.service.projectType.UdeaException;

public interface EstadoProyectoService {


	List<ProjectTypeDTO> getAll(Integer skip, Integer limit) throws UdeaException;
}
