package seguimproyectos_back.service.etapa;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.proyecto.etapa.EtapaProyectoDTO;

public interface EtapaProyectoService {

	public List<EtapaProyectoDTO> listarPorCodigoProyecto(String codigoProyecto) throws UdeaException;

}
