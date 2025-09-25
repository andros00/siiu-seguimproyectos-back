package seguimproyectos_back.service.selectionProcess;

import java.util.List;

import seguimproyectos_back.model.SelectionProcessDTO;
import co.edu.udea.utilities.exception.UdeaException;

public interface ISelectionProcessService {

	List<SelectionProcessDTO> getAll(Integer skip, Integer limit) throws UdeaException;

}
