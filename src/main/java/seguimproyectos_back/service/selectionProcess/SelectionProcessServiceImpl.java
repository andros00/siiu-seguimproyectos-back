package seguimproyectos_back.service.selectionProcess;

import java.util.List;

import org.springframework.stereotype.Service;

import seguimproyectos_back.dao.ProcesoSeleccionDao;
import seguimproyectos_back.model.SelectionProcessDTO;
import seguimproyectos_back.service.proyecto.UdeaException;

@Service
public class SelectionProcessServiceImpl implements ISelectionProcessService {

	private final ProcesoSeleccionDao repository;
		
	public SelectionProcessServiceImpl(ProcesoSeleccionDao repository) {
		this.repository = repository;
	}


	@Override
	public List<SelectionProcessDTO> getAll(Integer skip, Integer limit)throws UdeaException {
			return repository.getAll();
			
		}
	}
}
