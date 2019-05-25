package co.com.czuluaga.udemy.microservices.rsexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoudException extends RuntimeException {
	
	public ResourceNotFoudException(String message) {
		super(message);
	}
}
