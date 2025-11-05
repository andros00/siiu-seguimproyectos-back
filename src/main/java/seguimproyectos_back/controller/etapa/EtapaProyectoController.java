package seguimproyectos_back.controller.etapa;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody EtapaProyectoDTO dto) throws UdeaException {
		return ResponseEntity.ok(etapaProyectoService.insertar(dto));
	}

	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody EtapaProyectoDTO dto) throws UdeaException {
		return ResponseEntity.ok(etapaProyectoService.actualizar(dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) throws UdeaException {
		return ResponseEntity.ok(etapaProyectoService.eliminar(id));
	}

	@GetMapping("/proyecto/{codigo}")
	public ResponseEntity<?> listarPorProyecto(@PathVariable String codigo) throws UdeaException {
		return ResponseEntity.ok(etapaProyectoService.listarPorCodigoProyecto(codigo));
	}

	@GetMapping("/proyecto/{codigo}/desde/{fecha}")
	public ResponseEntity<?> listarDesdeFecha(@PathVariable String codigo, @PathVariable Date fecha)
			throws UdeaException {
		return ResponseEntity.ok(etapaProyectoService.consultarDesdeFecha(codigo, fecha));
	}

}
