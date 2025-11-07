package seguimproyectos_back.service.investigador.joven;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udea.util.UdeaException;
import seguimproyectos_back.dao.investigador.joven.JovenInvestigadorDao;
import seguimproyectos_back.model.investigador.joven.JovenInvestigadorDTO;

@Service
public class JovenInvestigadorServiceImpl implements JovenInvestigadorService{
	

	private final JovenInvestigadorDao dao;

	public JovenInvestigadorServiceImpl(JovenInvestigadorDao dao) {
		this.dao = dao;
	}

	@Override
	public List<JovenInvestigadorDTO> consultarJovenInvestigador(String identificacion) throws UdeaException {
		return dao.consultarJovenInvestigador(identificacion);
	}


}
