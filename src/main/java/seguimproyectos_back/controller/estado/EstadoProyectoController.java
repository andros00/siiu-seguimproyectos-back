package seguimproyectos_back.controller.estado;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.utilities.exception.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.EstadoProyectoDTO;
import seguimproyectos_back.service.estadosproyecto.EstadoProyectoService;

@RestController
@RequestMapping("/compartido")
@Api(value = "Estados proyectos", tags = {
		"Gestión de Estados de Proyectos" }, description = "API para la gestión y consulta de los Estados de los Proyectos de Investigación en la Universidad de Antioquia. "
				+ "Permite obtener información sobre los diferentes estados en los que puede encontrarse un proyecto.")
public class EstadoProyectoController {

	private final EstadoProyectoService estadoProyectoService;

	public EstadoProyectoController(EstadoProyectoService estadoProyectoService) {
		this.estadoProyectoService = estadoProyectoService;
	}

	@ApiOperation(value = "Obtener Estados de Proyectos", notes = "Retorna una lista con los diferentes Estados de los Proyectos de Investigación en la Universidad de Antioquia. "
			+ "Cada estado refleja la situación actual del proyecto dentro de su ciclo de vida.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de Estados de Proyectos recuperada exitosamente"),
			@ApiResponse(code = 204, message = "No se encontraron Estados de Proyectos"),
			@ApiResponse(code = 400, message = "Solicitud inválida"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/estados-proyecto")
	public ResponseEntity<List<EstadoProyectoDTO>> getAll() throws UdeaException {
		
//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(estadoProyectoService.getAll());
	}

}
