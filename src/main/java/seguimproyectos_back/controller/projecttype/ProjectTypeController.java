package seguimproyectos_back.controller.projecttype;

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
import seguimproyectos_back.model.ProjectTypeDTO;
import seguimproyectos_back.service.projectType.IProjectTypeService;

@RestController
@RequestMapping("/compartido")
@Api(value = "Tipos de proyectos", tags = {
		"Gestión de Tipos de Proyecto" }, description = "API para la gestión y consulta de los Tipos de Proyectos de Investigación en la Universidad de Antioquia. "
				+ "Permite obtener los diferentes tipos de proyectos a los cuales se pueden adscribir los investigadores.")
public class ProjectTypeController {

	private final IProjectTypeService projectTypeService;

	public ProjectTypeController(IProjectTypeService projectTypeService) {
		this.projectTypeService = projectTypeService;
	}

	@ApiOperation(value = "Obtener Tipos de Proyecto", notes = "Retorna una lista paginada con los Tipos de Proyectos de Investigación disponibles en la Universidad de Antioquia. "
			+ "Se soporta la paginación a través de los parámetros `skip` y `limit`.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de Tipos de Proyecto recuperada exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros de paginación inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Tipos de Proyecto"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/tipos-proyecto")
	public ResponseEntity<List<ProjectTypeDTO>> getAll(
			@ApiParam(value = "Número de registros a omitir (por defecto es 0)", example = "0") 
			@RequestParam(defaultValue = "0") Integer skip,

			@ApiParam(value = "Número máximo de registros a retornar (por defecto es 10)", example = "10") 
			@RequestParam(defaultValue = "10") Integer limit)
			throws UdeaException {
		
//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(projectTypeService.getAll(skip, limit));
	}
}
