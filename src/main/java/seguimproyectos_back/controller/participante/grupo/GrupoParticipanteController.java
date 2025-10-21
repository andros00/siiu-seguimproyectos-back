package seguimproyectos_back.controller.participante.grupo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.participante.VinculoParticipanteDTO;
import seguimproyectos_back.model.participante.grupo.GrupoParticipanteDTO;
import seguimproyectos_back.service.participante.grupo.GrupoParticipanteService;

@RestController
@RequestMapping("/participante")
@Api(value = "Grupo Participante", tags = {
		"Grupo Participante" }, description = "API para la gestión y consulta de los Grupos participantes de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")

public class GrupoParticipanteController {

	private final GrupoParticipanteService grupoParticipanteService;

	public GrupoParticipanteController(GrupoParticipanteService grupoParticipanteService) {
		super();
		this.grupoParticipanteService = grupoParticipanteService;
	}

	@ApiOperation(value = "Obtener Grupo Participante por identificacion", notes = "Retorna un Grupo participante de una persona natural. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Vinculo Participante recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Grupo Participante de la persona natural"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/vinculo-participante")
	public ResponseEntity<List<GrupoParticipanteDTO>> grupoParticipanteByIdentificaion(
			@ApiParam(value = "Identificacion persona natural", example = "1037000123") @RequestParam() String identificacion)
			throws UdeaException {
		return ResponseEntity.ok(grupoParticipanteService.consultarGrupoParticipanteByIdentificaion(identificacion));
	}

}
