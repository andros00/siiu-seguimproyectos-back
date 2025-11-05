package seguimproyectos_back.controller.compromiso.nota;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.util.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import seguimproyectos_back.model.compromiso.CompromisoNotaDTO;
import seguimproyectos_back.service.compromiso.nota.CompromisoNotaService;

@RestController
@RequestMapping("/compromiso")
@Api(value = "Compromiso-nota", tags = { "Compromiso-nota" }, description = "Gestión de notas de compromiso")
public class CompromisoNotaController {
	private final CompromisoNotaService service;

    public CompromisoNotaController(CompromisoNotaService service) {
        this.service = service;
    }

    @ApiOperation("Agregar una nota a un compromiso")
    @PostMapping("/nota")
    public ResponseEntity<Integer> insertarNota(@RequestBody CompromisoNotaDTO nota) throws UdeaException {
        int result = service.insertarNota(nota);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("Obtener notas de un compromiso por idCompromisoProyecto")
    @GetMapping("/nota/{idCompromisoProyecto}")
    public ResponseEntity<List<CompromisoNotaDTO>> obtenerNotas(@PathVariable Long idCompromisoProyecto) throws UdeaException {
        List<CompromisoNotaDTO> notas = service.obtenerNotasPorCompromiso(idCompromisoProyecto);
        return ResponseEntity.ok(notas);
    }

}
