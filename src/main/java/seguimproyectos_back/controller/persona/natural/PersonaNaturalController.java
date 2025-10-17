package seguimproyectos_back.controller.persona.natural;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import seguimproyectos_back.controller.participante.proyecto.UdeaException;
import seguimproyectos_back.model.personanatural.PersonaNaturalDTO;
import seguimproyectos_back.model.personanatural.PersonaNaturalRequest;
import seguimproyectos_back.service.persona.natural.PersonaNaturalService;

@RestController
@RequestMapping("/persona")
@Api(value = "Persona Natual", tags = {
		"Persona Natual" }, description = "API para la gestión y consulta de las Persona Natual de proyectos de la Universidad de Antioquia.")

public class PersonaNaturalController {

	private final PersonaNaturalService personaNaturalService;

	public PersonaNaturalController(PersonaNaturalService personaNaturalService) {
		this.personaNaturalService = personaNaturalService;
	}

	@ApiOperation(value = "Obtener Persona Natual por numero o nombre", notes = "Retorna una pPersona Natual de la Universidad de Antioquia. ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Persona Natual recuperados exitosamente"),
			@ApiResponse(code = 400, message = "Parámetros inválidos"),
			@ApiResponse(code = 404, message = "No se encontraron Persona Natual"),
			@ApiResponse(code = 500, message = "Error interno en el servidor") })
	@PostMapping("/persona-natual")
	public ResponseEntity<List<PersonaNaturalDTO>> participanteProyectoXCodigo(
			@RequestBody PersonaNaturalRequest persona) throws UdeaException {

		return ResponseEntity.ok(personaNaturalService.consultarPersona(persona));
	}

}
