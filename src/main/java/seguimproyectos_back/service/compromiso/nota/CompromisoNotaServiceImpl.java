package seguimproyectos_back.service.compromiso.nota;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.compromiso.nota.CompromisoNotaDao;
import seguimproyectos_back.model.compromiso.CompromisoNotaDTO;

@Service
public class CompromisoNotaServiceImpl implements CompromisoNotaService {
	private final CompromisoNotaDao dao;

    public CompromisoNotaServiceImpl(CompromisoNotaDao dao) {
        this.dao = dao;
    }

    @Transactional
    public int insertarNota(CompromisoNotaDTO nota) throws UdeaException {
        return dao.insert(nota);
    }

    @Transactional(readOnly = true)
    public List<CompromisoNotaDTO> obtenerNotasPorCompromiso(Long idCompromisoProyecto) throws UdeaException {
        return dao.findByCompromisoProyecto(idCompromisoProyecto);
    }

}
