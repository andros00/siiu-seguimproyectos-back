package seguimproyectos_back.service.persona.natural;

import java.util.List;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.model.personanatural.PersonaNaturalDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalRequest;

public interface PersonaNaturalService {

	PersonaNaturalDTO consultarPersona(String identificacion) throws UdeaException;

}
