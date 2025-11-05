package seguimproyectos_back.service.actividadproyecto;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.ActividadProyectoDao;
import seguimproyectos_back.model.ActividadProyectoDTO;

@Service
public class ActividadProyectoServiceImpl implements ActividadProyectoService {
	private final ActividadProyectoDao repository;
	
	public ActividadProyectoServiceImpl(ActividadProyectoDao repository) {
        this.repository = repository;
    }

	public List<ActividadProyectoDTO> consultarActividadXProyecto(String codigoProyecto) throws UdeaException {
        return repository.consultarActividadXProyecto(codigoProyecto);
    }

}
