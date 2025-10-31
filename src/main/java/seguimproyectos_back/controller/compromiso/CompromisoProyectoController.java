package seguimproyectos_back.controller.compromiso;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.util.UdeaException;
import io.swagger.annotations.Api;
import seguimproyectos_back.model.compromiso.CompromisoCentroDTO;
import seguimproyectos_back.model.compromiso.CompromisoProyectoDTO;
import seguimproyectos_back.service.compromiso.CompromisoProyectoService;

@RestController
@RequestMapping("/compromiso")
@Api(value = "compromiso", tags = {
		"compromiso" }, description = "API para la gestión y consulta de los compromiso de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")

public class CompromisoProyectoController {

	private CompromisoProyectoService service;

	public CompromisoProyectoController(CompromisoProyectoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Integer> insertar(@RequestBody CompromisoProyectoDTO compromiso) throws UdeaException {
		int result = service.insertar(compromiso);
		return ResponseEntity.ok(result);
	}

	@PutMapping
	public ResponseEntity<Integer> actualizar(@RequestBody CompromisoProyectoDTO compromiso) throws UdeaException {
		int result = service.actualizar(compromiso);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/{id}/fecha-estimada")
	public ResponseEntity<Integer> actualizarFechaEstimada(@PathVariable Long id, @RequestParam Date nuevaFecha,
			@RequestParam Long idSolicitudAdm, @RequestParam String usuario) throws UdeaException {
		int result = service.actualizarFechaEstimada(id, nuevaFecha, idSolicitudAdm, usuario);
		return ResponseEntity.ok(result);
	}

	@GetMapping
	public ResponseEntity<List<CompromisoProyectoDTO>> obtenerTodos() throws UdeaException {
		return ResponseEntity.ok(service.obtenerTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompromisoProyectoDTO> obtenerPorId(@PathVariable Long id) throws UdeaException {
		return ResponseEntity.ok(service.obtenerPorId(id));
	}

	@GetMapping("/proyecto/{codigo}")
	public ResponseEntity<List<CompromisoProyectoDTO>> buscarPorProyecto(@PathVariable String codigo)
			throws UdeaException {
		return ResponseEntity.ok(service.buscarPorProyecto(codigo));
	}

	@PostMapping("/centro")
	public ResponseEntity<List<CompromisoCentroDTO>> buscarPorCentro(@RequestBody CompromisoCentroDTO filtro)
			throws UdeaException {
		return ResponseEntity.ok(service.buscarPorCentro(filtro));
	}

}
