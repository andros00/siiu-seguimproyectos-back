package seguimproyectos_back.controller.participante.proyecto;

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
import seguimproyectos_back.model.ParticipanteProyectoDTO;
import seguimproyectos_back.service.participante.proyecto.ParticipanteProyectoService;

@RestController
@RequestMapping("/participante")
@Api(value = "ParticipanteProyecto", tags = {
		"ParticipanteProyecto" }, description = "API para la gestión y consulta de los participantes de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos los proyectos de investigación.")
public class ParticipanteProyectoController {
	
	private final ParticipanteProyectoService participanteProyectoService;

	public ParticipanteProyectoController(ParticipanteProyectoService participanteProyectoService) {
		this.participanteProyectoService = participanteProyectoService;
	}

	@ApiOperation(value = "Obtener Participantes por codigo de proyecto", notes = "Retorna una participante de un proyecto de la Universidad de Antioquia. ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Participantes recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Participantes"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/participantes-proyecto")
	public ResponseEntity<List<ParticipanteProyectoDTO>> participanteProyectoXCodigo(
			@ApiParam(value = "Codigo de proyecto", example = "2020-123")
			@RequestParam()  String codigoProyecto)
			throws UdeaException {
		
//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(participanteProyectoService.consultarParticipanteProyectoXCodigo(codigoProyecto));
	}
	
	@ApiOperation(value = "Obtener Participantes por codigo de proyecto", notes = "Retorna una participante de un proyecto de la Universidad de Antioquia. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Participantes recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Participantes"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/participante")
	public ResponseEntity<ParticipanteProyectoDTO> participantePorIdentificacion(
			@ApiParam(value = "Número de identificacion", example = "1037000123") @RequestParam() String identificacion)
			throws UdeaException {

		return ResponseEntity.ok(participanteProyectoService.consultarParticipanteXIdentificacion(identificacion));
	}
	

}
