package seguimproyectos_back.service.persona.natural;

import java.util.List;

import org.springframework.stereotype.Service;

import seguimproyectos_back.dao.PersonaNaturalDao;
import seguimproyectos_back.dao.UdeaException;
import seguimproyectos_back.model.personanatural.PersonaNaturalDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalRequest;

@Service
public class PersonaNaturalServiceImpl implements PersonaNaturalService {

	private PersonaNaturalDao reporitory;

	public PersonaNaturalServiceImpl(PersonaNaturalDao reporitory) {
		super();
		this.reporitory = reporitory;
	}

	@Override
	public List<PersonaNaturalDTO> consultarPersona(PersonaNaturalRequest persona) throws UdeaException {
		return reporitory.consultarPersona(persona);
	}

}
