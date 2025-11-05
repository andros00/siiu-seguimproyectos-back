package seguimproyectos_back.service.etapa;

import java.util.Date;
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

	public int insertar(EtapaProyectoDTO dto) throws UdeaException {
		return etapaProyectoDao.insert(mapToEntity(dto));
	}

	public int actualizar(EtapaProyectoDTO dto) throws UdeaException {
		return etapaProyectoDao.update(mapToEntity(dto));
	}

	public int eliminar(Long id) throws UdeaException {
		return etapaProyectoDao.delete(id);
	}

	public List<?> listarPorCodigoProyecto(String codigoProyecto) throws UdeaException {
		return etapaProyectoDao.findByCodigoProyecto(codigoProyecto);
	}

	public List<?> consultarDesdeFecha(String codigoProyecto, Date fecha) throws UdeaException {
		return etapaProyectoDao.consultarEtapasDesdeFecha(codigoProyecto, fecha);
	}

	private EtapaProyectoDTO mapToEntity(EtapaProyectoDTO dto) {
		EtapaProyectoDTO e = new EtapaProyectoDTO();
		e.setIdentificador(dto.getIdentificador());
		e.setNombre(dto.getNombre());
		e.setDescripcion(dto.getDescripcion());
		e.setEjecucionPresupuestal(dto.getEjecucionPresupuestal());
		e.setDuracion(dto.getDuracion());
		e.setInicioVigencia(dto.getInicioVigencia());
		e.setFinVigencia(dto.getFinVigencia());
		e.setCodigoProyecto(dto.getCodigoProyecto());
		e.setOrden(dto.getOrden());
		e.setConsecutivo(dto.getConsecutivo());
		e.setUsuarioCrea(dto.getUsuarioCrea());
		e.setUsuarioActualiza(dto.getUsuarioActualiza());
		return e;
	}

}
