package seguimproyectos_back.controller.announcement;

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
import seguimproyectos_back.model.AnnouncementDTO;
import seguimproyectos_back.service.announcement.IAnnouncementService;

@RestController
@RequestMapping("/convocatoria")
@Api(value = "Convocatoria", tags = {
		"Gestión de convocatoria" }, description = "API para la gestión y consulta de las Convocatorias de la Universidad de Antioquia, las cuales están asociadas a los proyectos de investigación.")
public class AnnouncementController {

	private final IAnnouncementService announcementService;

	public AnnouncementController(IAnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@ApiOperation(value = "Obtener Convocatorias", notes = "Retorna una lista paginada de las Convocatorias disponibles en la Universidad de Antioquia. "
			+ "Las convocatorias representan los procesos mediante los cuales se financian o apoyan los proyectos de investigación.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de Convocatorias recuperada exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros de paginación inválidos"),
			@ApiResponse(code = 204, message = "No se encontraron Convocatorias"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/lista-convocatorias")
	public ResponseEntity<List<AnnouncementDTO>> getAll(
			@ApiParam(value = "Número de registros a omitir (por defecto es 0)", example = "0") 
			@RequestParam(defaultValue = "0") Integer skip,

			@ApiParam(value = "Número máximo de registros a retornar (por defecto es 10)", example = "10") 
			@RequestParam(defaultValue = "10") Integer limit)
			throws UdeaException {
		
//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(announcementService.getAll(skip, limit));
	}
}
