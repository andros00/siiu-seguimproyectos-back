package seguimproyectos_back.controller.actividadproyecto;

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
import seguimproyectos_back.model.ActividadProyectoDTO;
import seguimproyectos_back.service.actividadproyecto.ActividadProyectoService;

@RestController
@RequestMapping("proyecto/actividad")
@Api(value = "Actividades Proyecto", tags = {
		"Actividades Proyecto" }, description = "API para la gestión y consulta de las actividades de los proyectos de investigación de la Universidad de Antioquia")

public class ActividadProyectoController {

	private final ActividadProyectoService actividadProyectoService;

	public ActividadProyectoController(ActividadProyectoService actividadProyectoService) {
		this.actividadProyectoService = actividadProyectoService;
	}

	@ApiOperation(value = "Obtener las actividades por codigo de proyecto", notes = "Retorna las actividades de un proyecto de la Universidad de Antioquia. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Actividades recuperadas exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron actividades"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/actividades-proyecto")
	public ResponseEntity<List<ActividadProyectoDTO>> consultarActividadXProyecto(
			@ApiParam(value = "Codigo de proyecto", example = "2020-123") @RequestParam() String codigoProyecto)
			throws UdeaException {

//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(actividadProyectoService.consultarActividadXProyecto(codigoProyecto));
	}

}
