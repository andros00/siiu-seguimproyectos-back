package seguimproyectos_back.service.compromiso;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.compromiso.CompromisoProyectoDao;
import seguimproyectos_back.model.compromiso.CompromisoCentroDTO;
import seguimproyectos_back.model.compromiso.CompromisoProyectoDTO;

@Service
public class CompromisoProyectoServiceImpl implements CompromisoProyectoService{

	private CompromisoProyectoDao repository;

	public CompromisoProyectoServiceImpl(CompromisoProyectoDao repository) {
		this.repository = repository;
	}

	public int insertar(CompromisoProyectoDTO compromiso) throws UdeaException {
		return repository.insert(compromiso);
	}

	public int actualizar(CompromisoProyectoDTO compromiso) throws UdeaException {
		return repository.update(compromiso);
	}

	public int actualizarFechaEstimada(Long id, Date nuevaFecha, Long idSolicitudAdm, String usuario)
			throws UdeaException {
		return repository.actualizarFechaEstimada(id, nuevaFecha, idSolicitudAdm, usuario);
	}

	public List<CompromisoProyectoDTO> obtenerTodos() throws UdeaException {
		return repository.findAll();
	}

	public CompromisoProyectoDTO obtenerPorId(Long id) throws UdeaException {
		return repository.findById(id);
	}

	public List<CompromisoProyectoDTO> buscarPorProyecto(String codigoProyecto) throws UdeaException {
		return repository.findByProyecto(codigoProyecto);
	}

	public List<CompromisoCentroDTO> buscarPorCentro(CompromisoCentroDTO filtro) throws UdeaException {
		return repository.findByCentro(filtro);
	}

}
