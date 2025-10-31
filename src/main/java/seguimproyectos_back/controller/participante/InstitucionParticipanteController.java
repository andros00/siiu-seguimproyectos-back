package seguimproyectos_back.controller.participante;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.util.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.participante.grupo.GrupoParticipanteDTO;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteDTO;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteRequest;
import seguimproyectos_back.model.personanatural.PersonaNaturalDTO;
import seguimproyectos_back.service.participante.grupo.GrupoParticipanteService;
import seguimproyectos_back.service.participante.institucion.InstitucionParticipanteService;



@RestController
@RequestMapping("/participante")
@Api(value = "Institucion Participante", tags = {
		"Institucion Participante" }, description = "API para la gestión y consulta de los Institucion participantes de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")

public class InstitucionParticipanteController {
	
	private final InstitucionParticipanteService institucionParticipanteService;

	public InstitucionParticipanteController(InstitucionParticipanteService institucionParticipanteService) {
		super();
		this.institucionParticipanteService = institucionParticipanteService;
	}
	
	
	@ApiOperation(value = "Obtener Institucion Participante por identificacion", notes = "Retorna un Institucion participante de una persona natural. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Vinculo Participante recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Institucion Participante de la persona natural"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@PostMapping("/institucion-participante")
	public ResponseEntity<List<InstitucionParticipanteDTO>> institucionParticipanteByIdentificaion(
			@RequestBody InstitucionParticipanteRequest institucionParticipante)
			throws UdeaException {
		return ResponseEntity.ok(institucionParticipanteService.consultarInstitucionParticipanteByIdentificaion(institucionParticipante));
	}

}
