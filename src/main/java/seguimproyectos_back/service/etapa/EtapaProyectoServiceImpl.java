package seguimproyectos_back.service.etapa;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.etapa.EtapaProyectoDao;
import seguimproyectos_back.model.proyecto.etapa.EtapaProyectoDTO;

@Service
@Transactional
public class EtapaProyectoServiceImpl implements EtapaProyectoService {

	private final EtapaProyectoDao etapaProyectoDao;

	public EtapaProyectoServiceImpl(EtapaProyectoDao etapaProyectoDao) {
		this.etapaProyectoDao = etapaProyectoDao;
	}

	public List<EtapaProyectoDTO> listarPorCodigoProyecto(String codigoProyecto) throws UdeaException {
		return etapaProyectoDao.findByCodigoProyecto(codigoProyecto);
	}

}
