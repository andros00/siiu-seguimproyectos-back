package seguimproyectos_back.service.project.type;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.dao.TipoProyectoDao;
import seguimproyectos_back.model.ProjectTypeDTO;

@Service
public class ProjectTypeServiceImpl implements IProjectTypeService {

	private final TipoProyectoDao repository;
//    private final IProjectTypeMapper projectTypeMapper;

	public ProjectTypeServiceImpl(TipoProyectoDao repository) {
		this.repository = repository;
	}

	@Override
	public List<ProjectTypeDTO> getAll(Integer skip, Integer limit) throws UdeaException {

		return repository.getAll();

//		ValidateParams.validatePaginationParams(skip, limit);
//		try {
//			List<ProjectType> projectTypes = repository.findAll(PageRequest.of(skip, limit)).getContent();
//
//			if (projectTypes.isEmpty()) {
//				throw new DataNotFoundException("No se encontraron tipos de proyecto.");
//			}
//			return Optional.of(projectTypeMapper.toDTO(projectTypes));
//		} catch (DataNotFoundException e) {
//			throw e;
//		} catch (IllegalArgumentException e) {
//			throw new IllegalArgumentException("Parámetros inválidos: skip=" + skip + " limit=" + limit);
//		} catch (Exception e) {
//			throw new RuntimeException("Error desconocido al intentar obtener los tipos de proyecto.", e);
//		}
	}
}
