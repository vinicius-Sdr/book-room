package br.com.book.room.quarto.presentation.exception;

import br.com.book.room.quarto.applicaton.exception.BookRoomDataIntegrityViolationException;
import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.applicaton.validacao.exception.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

	private static final String MSG_ERROR = "[Error ] - ";

	@ExceptionHandler({ BookRoomEntityNotFoundException.class, ValidationException.class })
	public ResponseEntity<ErrorMessage> entityNotFoundException(RuntimeException ex, HttpServletRequest request) {
		log.error(MSG_ERROR, ex);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.contentType(MediaType.APPLICATION_JSON)
			.body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException ex,
			HttpServletRequest request, BindingResult result) {
		log.error(MSG_ERROR, ex);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
			.contentType(MediaType.APPLICATION_JSON)
			.body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Campo(s) invalido(s)", result));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorMessage> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex,
			HttpServletRequest request) {
		log.error(MSG_ERROR, ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.contentType(MediaType.APPLICATION_JSON)
			.body(new ErrorMessage(request, HttpStatus.BAD_REQUEST,
					"Erro de leitura JSON: " + ex.getMostSpecificCause().getMessage()));
	}

	@ExceptionHandler({ BookRoomUniqueViolationException.class, BookRoomDataIntegrityViolationException.class })
	public ResponseEntity<ErrorMessage> uniqueViolationException(RuntimeException ex, HttpServletRequest request) {
		log.error("Api Error - ", ex);
		return ResponseEntity.status(HttpStatus.CONFLICT)
			.contentType(MediaType.APPLICATION_JSON)
			.body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
	}

}
