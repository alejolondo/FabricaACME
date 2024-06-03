package co.com.acme.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParameterValidationException extends RuntimeException {
	
	public ParameterValidationException(String message) {
        super(message);
    }

}
