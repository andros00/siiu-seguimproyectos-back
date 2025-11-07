package seguimproyectos_back.controller.investigador.joven;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.util.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.investigador.joven.JovenInvestigadorDTO;
import seguimproyectos_back.service.investigador.joven.JovenInvestigadorService;

@RestController
@RequestMapping("/investigador")
@Api(value = "Investigador", tags = {
		"Investigador" }, description = "API para la gestión y consulta de los Investigador de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")
public class JovenInvestigadorController {
	
	private final JovenInvestigadorService service;

	public JovenInvestigadorController(JovenInvestigadorService service) {
		this.service = service;
	}
	
	
	@ApiOperation(value = "Obtener Joven Investigador por codigoProyecto", notes = "Retorna un Joven Investigador de un proyecto. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Joven Investigador recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron  Joven Investigador de un proyecto "),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/joven-investigador")
	public ResponseEntity<List<JovenInvestigadorDTO>> consultarPorIdentificacion(@RequestParam String codigoProyecto)
			throws UdeaException {
		return ResponseEntity.ok(service.consultarJovenInvestigador(codigoProyecto));
	}

}
