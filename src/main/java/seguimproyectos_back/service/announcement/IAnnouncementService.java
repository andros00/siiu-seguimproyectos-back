package seguimproyectos_back.service.announcement;

import java.util.List;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.AnnouncementDTO;

public interface IAnnouncementService {

	List<AnnouncementDTO> getAll(Integer skip, Integer limit) throws UdeaException;
}
