package seguimproyectos_back.controller.proyecto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.utilities.exception.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.model.ProyectoDTO;
import seguimproyectos_back.service.proyecto.ConsultaProyectosService;

@RestController
@RequestMapping("/proyectos")
@Api(value = "Proyectos", tags = {
		"Gestión de Proyectos" }, description = "API para la gestión y consulta de los Proyectos de Investigación en la Universidad de Antioquia. "
				+ "Permite buscar proyectos específicos a partir de los filtros suministrados.")
public class ConsultaProyectosController {

	private final ConsultaProyectosService consultaProyectosService;

	public ConsultaProyectosController(ConsultaProyectosService consultaProyectosService) {
		this.consultaProyectosService = consultaProyectosService;
	}

	@ApiOperation(value = "Buscar Proyectos según filtros", notes = "Permite consultar uno o varios Proyectos de Investigación de la Universidad de Antioquia a partir de los filtros enviados en el cuerpo de la solicitud.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Proyecto(s) encontrado(s) exitosamente"),
			@ApiResponse(code = 404, message = "No se encontraron Proyectos con los filtros suministrados"),
			@ApiResponse(code = 400, message = "Solicitud inválida"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@PostMapping(value = "/consultar")
	public ResponseEntity<GenericResponse> consultar(
			@ApiParam(value = "Objeto Proyecto con los filtros de búsqueda", required = true) 
			@RequestBody ProyectoDTO proyecto)
			throws UdeaException {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData(consultaProyectosService.consultarProyecto(proyecto));
		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(genericResponse);
	}
}
