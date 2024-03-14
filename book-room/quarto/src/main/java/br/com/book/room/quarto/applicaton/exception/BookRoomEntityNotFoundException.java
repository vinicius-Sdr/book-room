package br.com.book.room.quarto.applicaton.exception;

import jakarta.persistence.EntityNotFoundException;

public class BookRoomEntityNotFoundException extends RuntimeException {

	public BookRoomEntityNotFoundException(String message) {
		super(message);
	}

	public BookRoomEntityNotFoundException(String message, EntityNotFoundException e) {
		super(message, e);
	}
}
