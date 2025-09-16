package seguimproyectos_back.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.edu.udea.utilities.exception.UdeaException;
import seguimproyectos_back.model.GenericResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UdeaException.class)
    public ResponseEntity<GenericResponse> handleUdeaException(UdeaException e) {
        GenericResponse response = new GenericResponse();
        response.setErrorResponse();
        response.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleException(Exception e) {
        GenericResponse response = new GenericResponse();
        response.setErrorResponse();
        response.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}