package br.com.book.room.quarto.presentation.exception;

import java.util.HashMap;
import java.util.Map;

import br.com.book.room.quarto.presentation.exception.swagger.ErrorMessageSwagger;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Getter
@ToString
public class ErrorMessage implements ErrorMessageSwagger {

	private final String path;

	private final String method;

	private final int status;

	private final String statusText;

	private final String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, String> errors;

	public ErrorMessage(HttpServletRequest request, HttpStatus status, String message) {
		this.path = request.getRequestURI();
		this.method = request.getMethod();
		this.status = status.value();
		this.statusText = status.getReasonPhrase();
		this.message = message;
	}

	public ErrorMessage(HttpServletRequest request, HttpStatus status, String message, BindingResult result) {
		this.path = request.getRequestURI();
		this.method = request.getMethod();
		this.status = status.value();
		this.statusText = status.getReasonPhrase();
		this.message = message;
		addErrors(result);
	}

	private void addErrors(BindingResult result) {
		this.errors = new HashMap<>();
		for (FieldError fieldError : result.getFieldErrors()) {
			this.errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
	}

}
