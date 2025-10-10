package seguimproyectos_back.service.inicioFormal;

import org.springframework.stereotype.Service;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.ProyectoIniFormalDao;
import seguimproyectos_back.model.ProyectoIniFormalDTO;

@Service
public class ProyectoInicioFormalServiceImpl implements ProyectoInicioFormalService {
	
	private final ProyectoIniFormalDao repository;
	
	public ProyectoInicioFormalServiceImpl(ProyectoIniFormalDao repository) {
		this.repository = repository;
	}

	@Override
	public ProyectoIniFormalDTO consultarInicioFormal(String codigoProyecto) throws UdeaException {
		// TODO Auto-generated method stub
		return repository.consultarInicioFormal(codigoProyecto);
	}

	@Override
	public ProyectoIniFormalDTO guardarInicioFormal(ProyectoIniFormalDTO proyectoIFormal) throws UdeaException {
		// TODO Auto-generated method stub
		return repository.actualizarInicioFormal(proyectoIFormal);
	}
	
	
}
