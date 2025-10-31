package seguimproyectos_back.controller.participante;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.util.UdeaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.model.participante.RolParticipanteDTO;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteDTO;
import seguimproyectos_back.model.participante.institucion.InstitucionParticipanteRequest;
import seguimproyectos_back.service.participante.institucion.InstitucionParticipanteService;
import seguimproyectos_back.service.participante.rol.RolParticipanteService;

@RestController
@RequestMapping("/participante")
@Api(value = "Rol Participante", tags = {
		"Rol Participante" }, description = "API para la gestión y consulta de los Rol participantes de proyectos de la Universidad de Antioquia, a los cuales se encuentran adscritos las persona natural.")

public class RoleParticipanteController {
	
	private final RolParticipanteService rolParticipanteService;

	public RoleParticipanteController(RolParticipanteService rolParticipanteService) {
		super();
		this.rolParticipanteService = rolParticipanteService;
	}
	
	
	@ApiOperation(value = "Obtener Rol Participante por identificacion", notes = "Retorna un Rol participante de una persona natural. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Vinculo Participante recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Rol Participante de la persona natural"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@GetMapping("/rol-participante")
	public ResponseEntity<List<RolParticipanteDTO>> rolParticipanteAll()
			throws UdeaException {
		return ResponseEntity.ok(rolParticipanteService.rolParticipanteAll());
	}

}
