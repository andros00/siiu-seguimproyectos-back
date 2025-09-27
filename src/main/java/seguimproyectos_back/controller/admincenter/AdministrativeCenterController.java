package seguimproyectos_back.controller.admincenter;

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
import seguimproyectos_back.model.AdministrativeCenterDTO;
import seguimproyectos_back.service.administrativeCenter.IAdministrativeCenterService;

@RestController
@RequestMapping("/compartido")
@Api(value = "CentroAdministrativo", tags = {
		"Gestión de Centros Administrativos" }, description = "API para la gestión y consulta de los Centros Administrativos de la Universidad de Antioquia, a los cuales se encuentran adscritos los proyectos de investigación.")
public class AdministrativeCenterController {

	private final IAdministrativeCenterService administrativeCenterService;

	public AdministrativeCenterController(IAdministrativeCenterService administrativeCenterService) {
		this.administrativeCenterService = administrativeCenterService;
	}

	@ApiOperation(value = "Obtener Centros Administrativos", notes = "Retorna una lista paginada de los Centros Administrativos de la Universidad de Antioquia. "
			+ "Estos centros representan las unidades administrativas a las que se encuentran adscritos los proyectos de investigación.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de Centros Administrativos recuperada exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros de paginación inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Centros Administrativos"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/centros-administrativos")
	public ResponseEntity<List<AdministrativeCenterDTO>> getAll(
			@ApiParam(value = "Número de registros a omitir (por defecto es 0)", example = "0")
			@RequestParam(defaultValue = "0") Integer skip,

			@ApiParam(value = "Número máximo de registros a retornar (por defecto es 10)", example = "10") 
			@RequestParam(defaultValue = "10") Integer limit)
			throws UdeaException {
		
//		GenericResponse genericResponse = new GenericResponse();
//		genericResponse.setData(announcementService.getAll(skip, limit));
//		genericResponse.setSuccessResponse();
		return ResponseEntity.ok(administrativeCenterService.getAll(skip, limit));
	}
}
