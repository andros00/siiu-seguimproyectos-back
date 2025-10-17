package seguimproyectos_back.service.participante.vinculo;

import java.util.List;

import org.springframework.stereotype.Service;

import seguimproyectos_back.dao.participante.vinculo.VinculoParticipanteDao;
import seguimproyectos_back.model.participante.VinculoParticipanteDTO;

@Service
public class VinculoParticipanteServiceImpl implements VinculoParticipanteService {

	private VinculoParticipanteDao reppository;

	public VinculoParticipanteServiceImpl(VinculoParticipanteDao reppository) {
		this.reppository = reppository;
	}

	@Override
	public List<VinculoParticipanteDTO> consultarVinculoParticipanteByIdentificaion(String indentificacion)
			throws UdeaException {
		// TODO Auto-generated method stub
		return null;
	}

}
