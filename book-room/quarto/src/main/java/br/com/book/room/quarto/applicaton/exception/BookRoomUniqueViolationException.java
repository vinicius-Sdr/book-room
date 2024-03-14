package br.com.book.room.quarto.applicaton.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class BookRoomUniqueViolationException extends RuntimeException {

	public BookRoomUniqueViolationException(String message, DataIntegrityViolationException e) {
		super(message, e);
	}

}
