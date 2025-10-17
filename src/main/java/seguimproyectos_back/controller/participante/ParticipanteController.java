package seguimproyectos_back.controller.participante;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.controller.participante.vinculo.UdeaException;
import seguimproyectos_back.model.participante.ParticipanteDTO;
import seguimproyectos_back.model.participante.VinculoParticipanteDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalRequest;
import seguimproyectos_back.service.participante.ParticipanteService;
import seguimproyectos_back.service.participante.vinculo.VinculoParticipanteService;

@RestController
@RequestMapping("/participante")
@Api(value = "Vinculo Participante", tags = {
		"Vinculo Participante" }, description = "API para la gestión y consulta de los vinculos participantes de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")

public class ParticipanteController {
	
	
	private final ParticipanteService participanteService;

	@ApiOperation(value = "Obtener Persona Natual por numero o nombre", notes = "Retorna una pPersona Natual de la Universidad de Antioquia. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Persona Natual recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Persona Natual"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@PutMapping()
	public ResponseEntity<List<ParticipanteDTO>> updateParticipante(
			@RequestBody ParticipanteDTO participante) throws UdeaException {

		return ResponseEntity.ok(participanteService.actualizarParticipante(participante));
	}

}
