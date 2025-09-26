package seguimproyectos_back.controller.estado;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.utilities.exception.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.EstadoProyectoDTO;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.model.Proyecto;
import seguimproyectos_back.service.estadosproyecto.EstadoProyectoService;

@RestController
@RequestMapping("/commpartido")
@Api(value = "Proyectos", tags = { "Gestión de Estados de proyectos" })
public class EstadoProyectoController {

	private final EstadoProyectoService estadoProyectoService;

	public EstadoProyectoController(EstadoProyectoService estadoProyectoService) {
		this.estadoProyectoService = estadoProyectoService;
	}

	@ApiOperation(value = "Retrieve a paginated list of Announcements (Convocatorias)", notes = "Fetch a list of announcements (convocatorias) with pagination support.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of announcements retrieved successfully"),
			@ApiResponse(code = 400, message = "Invalid pagination parameters"),
			@ApiResponse(code = 204, message = "No announcements found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/estados-proyecto")
	public ResponseEntity<List<EstadoProyectoDTO>> getAll() throws UdeaException {

//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(estadoProyectoService.getAll());
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(estadoProyectoService.getAll());
	}

}
