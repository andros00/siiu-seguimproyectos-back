package seguimproyectos_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.utilities.exception.UdeaException;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.bl.interfaces.ConsultaProyectosService;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.model.Proyecto;

@RestController
@RequestMapping("proyectos")
//@Api(value = "Proyectos", tags = { "Gestión de proyectos" })
public class ConsultaProyectosController {

	private final ConsultaProyectosService consultaProyectosService;

	public ConsultaProyectosController(ConsultaProyectosService consultaProyectosService) {
		this.consultaProyectosService = consultaProyectosService;
	}

	@GetMapping
	public String obteneVariableCertificado() {
		return "Hola mundo";
	}

//	@APIOPERATION(VALUE = "BUSCAR PROYECTOS SEGÚN LOS FILTROS SUMINISTRADOS", NOTES = "PROVEE UNO O VARIOS PROYECTOS ESPECÍFICO")
//	@APIRESPONSES(VALUE = { @APIRESPONSE(CODE = 200, MESSAGE = "PROYECTO ENCONTRADO"),
//			@APIRESPONSE(CODE = 404, MESSAGE = "PROYECTO NO ENCONTRADO") })

	@PostMapping(value = "/consultar")
	public ResponseEntity<GenericResponse> consultar(@RequestBody Proyecto proyecto) throws UdeaException {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData(consultaProyectosService.consultarProyecto(proyecto));
		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(genericResponse);
	}
}
