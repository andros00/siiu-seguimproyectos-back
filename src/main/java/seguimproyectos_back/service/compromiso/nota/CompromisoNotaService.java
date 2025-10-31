package seguimproyectos_back.service.compromiso.nota;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.compromiso.CompromisoNotaDTO;

public interface CompromisoNotaService {

	int insertarNota(CompromisoNotaDTO nota) throws UdeaException;

    List<CompromisoNotaDTO> obtenerNotasPorCompromiso(Long idCompromisoProyecto) throws UdeaException;

}
