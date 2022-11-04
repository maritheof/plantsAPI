package demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class ControllerAdvisor {

	@ExceptionHandler(PlantNotFoundException.class)
	public ResponseEntity<Object> handlePlantNotFoundException(PlantNotFoundException ex, WebRequest request) {	        
	        return new ResponseEntity<>(ex.getBody(), HttpStatus.NOT_FOUND);
	    }
	
	@ExceptionHandler(PlantBadRequestException.class)
	public ResponseEntity<Object> handlePlantBadRequestException(PlantBadRequestException ex, WebRequest request) {
	        return new ResponseEntity<>(ex.getBody(), HttpStatus.BAD_REQUEST);
	    }
}