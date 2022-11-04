package demo.exceptions;

import java.util.Map;

@SuppressWarnings("serial")
public class PlantNotFoundException extends RuntimeException {
	
	private Long id;
	
	public PlantNotFoundException(Long id) {
		this.id = id;
    }
    
	public Map<String, Object> getBody(){
		ExceptionBody body = new ExceptionBody(404, "Plant id doesn't exist", String.format("/plants/%d", id));
		return body.exceptionBody();
	}
}
