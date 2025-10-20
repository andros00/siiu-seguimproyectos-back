package seguimproyectos_back.controller.participante.vinculo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.util.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.participante.VinculoParticipanteDTO;
import seguimproyectos_back.service.participante.vinculo.VinculoParticipanteService;

@RestController
@RequestMapping("/participante")
@Api(value = "Vinculo Participante", tags = {
		"Vinculo Participante" }, description = "API para la gestión y consulta de los vinculos participantes de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")

public class VinculoParticipanteController {

	private final VinculoParticipanteService vinculoParticipanteService;

	public VinculoParticipanteController(VinculoParticipanteService vinculoParticipanteService) {
		this.vinculoParticipanteService = vinculoParticipanteService;
	}

	@ApiOperation(value = "Obtener Vinculo Participante por identificacion", notes = "Retorna un vinculo participante de una persona natural. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Vinculo Participante recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron vinculo Participante de la persona natural"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/vinculo-participante")
	public ResponseEntity<List<VinculoParticipanteDTO>> vinculoParticipanteByIdentificaion(
			@ApiParam(value = "Identificacion persona natural", example = "1037000123") @RequestParam() String identificacion)
			throws UdeaException {
		return ResponseEntity
				.ok(vinculoParticipanteService.consultarVinculoParticipanteByIdentificaion(identificacion));
	}

}
