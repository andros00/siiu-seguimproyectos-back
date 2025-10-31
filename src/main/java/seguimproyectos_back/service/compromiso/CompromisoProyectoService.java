package seguimproyectos_back.service.compromiso;

import java.util.Date;
import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.compromiso.CompromisoCentroDTO;
import seguimproyectos_back.model.compromiso.CompromisoProyectoDTO;

public interface CompromisoProyectoService {

	public int insertar(CompromisoProyectoDTO compromiso) throws UdeaException;

	public int actualizar(CompromisoProyectoDTO compromiso) throws UdeaException;

	public int actualizarFechaEstimada(Long id, Date nuevaFecha, Long idSolicitudAdm, String usuario)
			throws UdeaException;

	public List<CompromisoProyectoDTO> obtenerTodos() throws UdeaException;

	public CompromisoProyectoDTO obtenerPorId(Long id) throws UdeaException;

	public List<CompromisoProyectoDTO> buscarPorProyecto(String codigoProyecto) throws UdeaException;

	public List<CompromisoCentroDTO> buscarPorCentro(CompromisoCentroDTO filtro) throws UdeaException;

}
