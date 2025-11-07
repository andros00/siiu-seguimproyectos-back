package seguimproyectos_back.service.investigador.joven;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.investigador.joven.JovenInvestigadorDTO;

public interface JovenInvestigadorService {
	
	List<JovenInvestigadorDTO> consultarJovenInvestigador(String identificacion) throws UdeaException;

}
