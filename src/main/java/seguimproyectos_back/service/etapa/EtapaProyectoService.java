package seguimproyectos_back.service.etapa;

import java.util.Date;
import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.proyecto.etapa.EtapaProyectoDTO;

public interface EtapaProyectoService {

	public int insertar(EtapaProyectoDTO dto) throws UdeaException;

	public int actualizar(EtapaProyectoDTO dto) throws UdeaException;

	public int eliminar(Long id) throws UdeaException;

	public List<?> listarPorCodigoProyecto(String codigoProyecto) throws UdeaException;

	public List<?> consultarDesdeFecha(String codigoProyecto, Date fecha) throws UdeaException;
}
