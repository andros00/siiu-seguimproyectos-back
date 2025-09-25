package seguimproyectos_back.service.selectionProcess;

import java.util.List;

import seguimproyectos_back.model.SelectionProcessDTO;
import seguimproyectos_back.service.proyecto.UdeaException;

public interface ISelectionProcessService {

	List<SelectionProcessDTO> getAll(Integer skip, Integer limit) throws UdeaException;

}
