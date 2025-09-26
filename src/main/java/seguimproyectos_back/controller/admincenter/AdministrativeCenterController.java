package seguimproyectos_back.controller.admincenter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.AdministrativeCenterDTO;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.service.administrativeCenter.IAdministrativeCenterService;

@RestController
@RequestMapping("/compartido")
@Api(value = "Proyectos", tags = { "Gestión de Administracion de Centros" })
public class AdministrativeCenterController {

	private final IAdministrativeCenterService administrativeCenterService;

	public AdministrativeCenterController(IAdministrativeCenterService administrativeCenterService) {
		this.administrativeCenterService = administrativeCenterService;
	}

	@ApiOperation(value = "Retrieve a paginated list of Administrative Centers", notes = "Fetch a list of administrative centers with pagination support.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of Administrative Centers retrieved successfully"),
			@ApiResponse(code = 400, message = "Invalid pagination parameters"),
			@ApiResponse(code = 404, message = "No Administrative Centers found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/centros-administrativos")
	public ResponseEntity<List<AdministrativeCenterDTO>> getAll(@RequestParam(defaultValue = "0") Integer skip,
			@RequestParam(defaultValue = "10") Integer limit) throws UdeaException {

//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(administrativeCenterService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(administrativeCenterService.getAll(skip, limit));

	}
}
