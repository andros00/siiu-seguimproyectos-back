package seguimproyectos_back.service.administrativeCenter;

import java.util.List;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.AdministrativeCenterDTO;

public interface IAdministrativeCenterService {

	List<AdministrativeCenterDTO> getAll(Integer skip, Integer limit) throws UdeaException;
}
