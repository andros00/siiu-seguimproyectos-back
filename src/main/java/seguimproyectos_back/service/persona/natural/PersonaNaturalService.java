package seguimproyectos_back.service.persona.natural;

import java.util.List;

import seguimproyectos_back.model.personanatural.PersonaNaturalDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalRequest;

public interface PersonaNaturalService {

	List<PersonaNaturalDTO> consultarPersona(PersonaNaturalRequest persona) throws UdeaException;

}
