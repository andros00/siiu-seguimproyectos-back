package seguimproyectos_back.service.projectType;

import java.util.List;

import seguimproyectos_back.model.ProjectTypeDTO;

public interface IProjectTypeService {

	List<ProjectTypeDTO> getAll(Integer skip, Integer limit) throws UdeaException;
}
