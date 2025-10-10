package seguimproyectos_back.service.inicioFormal;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.ProyectoIniFormalDTO;

public interface ProyectoInicioFormalService {
	ProyectoIniFormalDTO consultarInicioFormal(String codigoProyecto) throws UdeaException;

	ProyectoIniFormalDTO guardarInicioFormal(ProyectoIniFormalDTO proyectoIFormal) throws UdeaException;

}
