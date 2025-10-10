package seguimproyectos_back.controller.participanteProyecto;

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
import seguimproyectos_back.service.participanteProyecto.ParticipanteProyectoService;

@RestController
@RequestMapping("/participante")
@Api(value = "ParticipanteProyecto", tags = {
		"ParticipanteProyecto" }, description = "API para la gestión y consulta de los Centros Administrativos de la Universidad de Antioquia, a los cuales se encuentran adscritos los proyectos de investigación.")
public class ParticipanteProyectoController {
	
	private final ParticipanteProyectoService participanteProyectoService;

	public ParticipanteProyectoController(ParticipanteProyectoService participanteProyectoService) {
		this.participanteProyectoService = participanteProyectoService;
	}

	@ApiOperation(value = "Obtener Centros Administrativos", notes = "Retorna una lista paginada de los Centros Administrativos de la Universidad de Antioquia. "
			+ "Estos centros representan las unidades administrativas a las que se encuentran adscritos los proyectos de investigación.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de Centros Administrativos recuperada exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros de paginación inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Centros Administrativos"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/participantes-proyecto")
	public ResponseEntity<List<ParticipanteProyectoDTO>> participanteProyectoXCodigo(
			@ApiParam(value = "Número de registros a omitir (por defecto es 0)", example = "0")
			@RequestParam(defaultValue = "0")  String codigoProyecto)
			throws UdeaException {
		
//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(participanteProyectoService.consultarParticipanteProyectoXCodigo(codigoProyecto));
	}
	

}
