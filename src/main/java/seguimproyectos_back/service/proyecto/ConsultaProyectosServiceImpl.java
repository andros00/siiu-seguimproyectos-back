package seguimproyectos_back.service.proyecto;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.dao.ConsultaProyectosDao;
import seguimproyectos_back.model.Proyecto;


@Service
public class ConsultaProyectosServiceImpl implements ConsultaProyectosService {

	private final ConsultaProyectosDao consultaProyectosDao;

	ConsultaProyectosServiceImpl(ConsultaProyectosDao consultaProyectosDao) {
		this.consultaProyectosDao = consultaProyectosDao;
	}
	
	@Override
    public List<Proyecto> consultarProyecto(Proyecto proyecto) throws UdeaException {
        return consultaProyectosDao.consultaProyectos(proyecto);
    }
	
}
