package seguimproyectos_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.bl.interfaces.ConsultaProyectosService;
import seguimproyectos_back.model.Proyecto;

@RestController
@RequestMapping("Proyecto")
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

	@GetMapping("/consulta")
	public List<Proyecto> consultar(@RequestBody Proyecto proyecto) throws UdeaException {
		return consultaProyectosService.consultarProyecto(proyecto);
	}
}
