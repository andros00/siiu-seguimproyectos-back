package seguimproyectos_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.bl.interfaces.ConsultaProyectosService;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.model.Proyecto;

@RestController
@RequestMapping("proyectos")
public class ConsultaProyectosController {

	private final ConsultaProyectosService consultaProyectosService;

	@Autowired
	public ConsultaProyectosController(ConsultaProyectosService consultaProyectosService) {
		this.consultaProyectosService = consultaProyectosService;
	}

	@GetMapping
	public String obteneVariableCertificado() {
		return "Hola mundo";
	}
	
	@PostMapping(value = "/consultar")
	public ResponseEntity<GenericResponse> consultar(@RequestBody Proyecto proyecto) throws UdeaException {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData(consultaProyectosService.consultarProyecto(proyecto));
		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(genericResponse);
	}
}
