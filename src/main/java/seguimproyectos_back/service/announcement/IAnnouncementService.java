package seguimproyectos_back.service.announcement;

import java.util.List;

import seguimproyectos_back.controller.projecttype.UdeaException;
import seguimproyectos_back.model.AnnouncementDTO;

public interface IAnnouncementService {

	List<AnnouncementDTO> getAll(Integer skip, Integer limit) throws UdeaException;
}
