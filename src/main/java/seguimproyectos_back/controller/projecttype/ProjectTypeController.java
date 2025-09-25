package seguimproyectos_back.controller.projecttype;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.controller.proyecto.UdeaException;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.model.ProjectTypeDTO;
import seguimproyectos_back.model.Proyecto;
import seguimproyectos_back.service.projectType.IProjectTypeService;

@RestController
@RequestMapping("/v1/compartido")
@Api(value = "Proyectos", tags = { "Gestión de tipo proyecto" })
public class ProjectTypeController {

	private final IProjectTypeService projectTypeService;

	public ProjectTypeController(IProjectTypeService projectTypeService) {
		this.projectTypeService = projectTypeService;
	}

	@ApiOperation(value = "Get paginated project types", notes = "Fetches project types using pagination with optional parameters for skip and limit.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of project types retrieved successfully"),
			@ApiResponse(code = 400, message = "Invalid pagination parameters"),
			@ApiResponse(code = 404, message = "No project types found"),
			@ApiResponse(code = 500, message = "Internal server error") })

	@GetMapping("/tipos-proyecto")
	public ResponseEntity<GenericResponse> getAll(@RequestParam(defaultValue = "0") Integer skip,
			@RequestParam(defaultValue = "10") Integer limit) throws UdeaException {

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData(projectTypeService.getAll(skip, limit));
		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(genericResponse);

	}

}
