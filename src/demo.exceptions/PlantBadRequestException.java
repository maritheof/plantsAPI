package demo.exceptions;

import java.util.Map;

@SuppressWarnings("serial")
public class PlantBadRequestException extends RuntimeException {
	
	public PlantBadRequestException() {
	}
	
	public Map<String, Object> getBody(){
		ExceptionBody body = new ExceptionBody(400, "plantName cannot be null", "/plants");
		return body.exceptionBody();
	}
}
