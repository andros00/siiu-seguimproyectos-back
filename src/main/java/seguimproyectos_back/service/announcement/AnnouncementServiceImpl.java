package seguimproyectos_back.service.announcement;

import java.util.List;

import org.springframework.stereotype.Service;

import seguimproyectos_back.controller.projecttype.UdeaException;
import seguimproyectos_back.dao.ConvocatoriaDao;
import seguimproyectos_back.model.AnnouncementDTO;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

	private final ConvocatoriaDao repository;

	public AnnouncementServiceImpl(ConvocatoriaDao repository) {
		this.repository = repository;
	}

	@Override
	public List<AnnouncementDTO> getAll(Integer skip, Integer limit) throws UdeaException {
		return repository.getAll();
	}
}
