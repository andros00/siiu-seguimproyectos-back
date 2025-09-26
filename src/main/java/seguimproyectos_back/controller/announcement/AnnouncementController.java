package seguimproyectos_back.controller.announcement;

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
import seguimproyectos_back.model.AnnouncementDTO;
import seguimproyectos_back.model.GenericResponse;
import seguimproyectos_back.service.announcement.IAnnouncementService;

@RestController
@RequestMapping("/convocatoria")
@Api(value = "Proyectos", tags = { "Gestión de convocatoria" })
public class AnnouncementController {

	private final IAnnouncementService announcementService;

	public AnnouncementController(IAnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@ApiOperation(value = "Retrieve a paginated list of Announcements (Convocatorias)", notes = "Fetch a list of announcements (convocatorias) with pagination support.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of announcements retrieved successfully"),
			@ApiResponse(code = 400, message = "Invalid pagination parameters"),
			@ApiResponse(code = 204, message = "No announcements found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/lista-convocatorias")
	public ResponseEntity<List<AnnouncementDTO>> getAll(@RequestParam(defaultValue = "0") Integer skip,
			@RequestParam(defaultValue = "10") Integer limit) throws UdeaException {

//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(announcementService.getAll(skip, limit));
	}
}
