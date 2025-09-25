package seguimproyectos_back.controller.estado;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.controller.proyecto.UdeaException;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.model.Proyecto;
import seguimproyectos_back.service.estadosproyecto.EstadoProyectoService;
import seguimproyectos_back.service.proyecto.ConsultaProyectosService;

@RestController
@RequestMapping("/commpartido")
@Api(value = "Proyectos", tags = { "Gestión de Estados de proyectos" })
public class EstadoProyectoController {

	private final EstadoProyectoService estadoProyectoService;

	public EstadoProyectoController(EstadoProyectoService estadoProyectoService) {
		this.estadoProyectoService = estadoProyectoService;
	}

	@ApiOperation(value = "BUSCAR PROYECTOS SEGÚN LOS FILTROS SUMINISTRADOS", notes = "PROVEE UNO O VARIOS PROYECTOS ESPECÍFICO")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "PROYECTO ENCONTRADO"),
			@ApiResponse(code = 404, message = "PROYECTO NO ENCONTRADO") })

	@PostMapping(value = "/estados-proyecto")
	public ResponseEntity<GenericResponse> consultar(@RequestBody Proyecto proyecto) throws UdeaException {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData(estadoProyectoService.getAll());
		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(genericResponse);
	}

}
