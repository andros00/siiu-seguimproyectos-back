package seguimproyectos_back.service.administrativeCenter;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.dao.CentroAdministrativoDao;
import seguimproyectos_back.model.AdministrativeCenterDTO;

@Service
public class AdministrativeCenterServiceImpl implements IAdministrativeCenterService {

	private final CentroAdministrativoDao repository;

	public AdministrativeCenterServiceImpl(CentroAdministrativoDao repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<AdministrativeCenterDTO> getAll(Integer skip, Integer limit) throws UdeaException {

		return repository.getAll();

	}
}
