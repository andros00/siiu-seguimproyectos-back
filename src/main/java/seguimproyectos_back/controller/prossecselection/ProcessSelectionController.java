package seguimproyectos_back.controller.prossecselection;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.utilities.exception.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.SelectionProcessDTO;
import seguimproyectos_back.service.selectionProcess.ISelectionProcessService;

@RestController
@RequestMapping("/compartido")
@Api(value = "Procesos de seleccion", tags = {
		"Gestión de Procesos de Selección" }, description = "API para la gestión y consulta de los Procesos de Selección asociados a los Proyectos de Investigación en la Universidad de Antioquia. "
				+ "Permite obtener los diferentes procesos de selección con soporte de paginación.")
public class ProcessSelectionController {

	private final ISelectionProcessService selectionProcessService;

	public ProcessSelectionController(ISelectionProcessService processSelectionService) {
		this.selectionProcessService = processSelectionService;
	}

	@ApiOperation(value = "Obtener Procesos de Selección", notes = "Retorna una lista paginada de los Procesos de Selección de Proyectos de Investigación en la Universidad de Antioquia. "
			+ "La consulta soporta paginación mediante los parámetros `skip` y `limit`.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de Procesos de Selección recuperada exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros de paginación inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Procesos de Selección"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/filtro-proceso-seleccion")
	public ResponseEntity<List<SelectionProcessDTO>> getAll(
			@ApiParam(value = "Número de registros a omitir (por defecto es 0)", example = "0") 
			@RequestParam(defaultValue = "0") Integer skip,

			@ApiParam(value = "Número máximo de registros a retornar (por defecto es 10)", example = "10") 
			@RequestParam(defaultValue = "10") Integer limit)
			throws UdeaException {
		
//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(selectionProcessService.getAll(skip, limit));
	}
}
