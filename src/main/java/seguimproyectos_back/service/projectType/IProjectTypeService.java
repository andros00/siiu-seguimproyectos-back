package seguimproyectos_back.service.projectType;

import java.util.List;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.ProjectTypeDTO;

public interface IProjectTypeService {

	List<ProjectTypeDTO> getAll(Integer skip, Integer limit) throws UdeaException;
}
