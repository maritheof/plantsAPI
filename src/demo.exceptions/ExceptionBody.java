package demo.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

class ExceptionBody {

	private int status;
	private String message;
	private String path;
	
	ExceptionBody(int status, String message, String path){
		this.status = status;
		this.message = message;
		this.path = path;
	}
	
	Map<String, Object> exceptionBody() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", this.status);
        body.put("message", this.message);
        body.put("path", this.path);
        return body;
	}
}
