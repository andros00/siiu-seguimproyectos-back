package seguimproyectos_back.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * HealthController provides a simple health check endpoint for the API. This
 * endpoint can be used to verify that the API is running and accessible.
 */
@RestController
@RequestMapping("/health")
public class PingController {

	/**
	 * Health check endpoint to verify that the API is running.
	 *
	 * @return A simple confirmation message that the API is running.
	 */
	@ApiOperation(value = "Health Check", notes = "Returns a simple message to indicate that the API is operational.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "API is running successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("/")
	public ResponseEntity<String> check() {
		return new ResponseEntity<>("API is running", HttpStatus.OK);
	}
}
