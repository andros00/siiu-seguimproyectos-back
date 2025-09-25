package seguimproyectos_back.controller.proyecto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.utilities.exception.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.model.Proyecto;
import seguimproyectos_back.service.proyecto.ConsultaProyectosService;

@RestController
@RequestMapping("/proyectos")
@Api(value = "Proyectos", tags = { "Gestión de proyectos" })
public class ConsultaProyectosController {

	private final ConsultaProyectosService consultaProyectosService;

	public ConsultaProyectosController(ConsultaProyectosService consultaProyectosService) {
		this.consultaProyectosService = consultaProyectosService;
	}

	@ApiOperation(value = "BUSCAR PROYECTOS SEGÚN LOS FILTROS SUMINISTRADOS", notes = "PROVEE UNO O VARIOS PROYECTOS ESPECÍFICO")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "PROYECTO ENCONTRADO"),
			@ApiResponse(code = 404, message = "PROYECTO NO ENCONTRADO") })

	@PostMapping(value = "/consultar")
	public ResponseEntity<GenericResponse> consultar(@RequestBody Proyecto proyecto) throws UdeaException {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData(consultaProyectosService.consultarProyecto(proyecto));
		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(genericResponse);
	}
}
