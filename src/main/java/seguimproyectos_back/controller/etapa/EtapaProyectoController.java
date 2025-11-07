package seguimproyectos_back.controller.etapa;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.util.UdeaException;
import io.swagger.annotations.Api;
import seguimproyectos_back.model.proyecto.etapa.EtapaProyectoDTO;
import seguimproyectos_back.service.etapa.EtapaProyectoService;

@RestController
@RequestMapping("/proyecto/etapa")
@Api(value = "Etapa Proyecto", tags = {
		"Etapa Proyecto" }, description = "API para la gestión y consulta de las etapas de los proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")

public class EtapaProyectoController {

	private final EtapaProyectoService etapaProyectoService;

	public EtapaProyectoController(EtapaProyectoService etapaProyectoService) {
		this.etapaProyectoService = etapaProyectoService;
	}

	@GetMapping
	public ResponseEntity<List<EtapaProyectoDTO>> listarPorProyecto(@RequestParam() String codigoProyecto) throws UdeaException {
		return ResponseEntity.ok(etapaProyectoService.listarPorCodigoProyecto(codigoProyecto));
	}


}
