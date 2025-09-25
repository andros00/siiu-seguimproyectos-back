package seguimproyectos_back.controller.prossecselection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.controller.projecttype.UdeaException;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.service.selectionProcess.ISelectionProcessService;

@RestController
@RequestMapping("/v1/administrador")
@Api(value = "Proyectos", tags = { "Gestión de procesos de Seleccion" })
public class ProcessSelectionController {

	private final ISelectionProcessService selectionProcessService;

	public ProcessSelectionController(ISelectionProcessService processSelectionService) {
		this.selectionProcessService = processSelectionService;
	}

	@ApiOperation(value = "Retrieve a paginated list of process selection", notes = "Fetch a list of process selection with pagination support."

	)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of Process Selections retrieved successfully"),
			@ApiResponse(code = 400, message = "Invalid pagination parameters"),
			@ApiResponse(code = 404, message = "No Process Selections found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/filtro-proceso-seleccion")
	public ResponseEntity<GenericResponse> getAll(@RequestParam(defaultValue = "0") Integer skip,

			@RequestParam(defaultValue = "10") Integer limit) throws UdeaException {

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData(selectionProcessService.getAll(skip, limit));
		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(genericResponse);

	}
}
