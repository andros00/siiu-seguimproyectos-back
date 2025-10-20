package seguimproyectos_back.controller.participante;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.util.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.participante.ParticipanteDTO;
import seguimproyectos_back.service.participante.ParticipanteService;

@RestController
@RequestMapping("/participante")
@Api(value = "Participante", tags = {
		"Participante" }, description = "API para la gestión y consulta de los participantes de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")

public class ParticipanteController {
	
	
	private final ParticipanteService participanteService = null;

	@ApiOperation(value = "Actualiza Participante", notes = "Retorna una participante actualizado de la Universidad de Antioquia. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Persona Natual recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Participante"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@PutMapping()
	public ResponseEntity<List<ParticipanteDTO>> updateParticipante(
			@RequestBody ParticipanteDTO participante) throws UdeaException {

		return ResponseEntity.ok(participanteService.actualizarParticipante(participante));
	}

}
