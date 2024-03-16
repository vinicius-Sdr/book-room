package br.com.book.room.quarto.applicaton.exception;

public class BookRoomDataIntegrityViolationException extends RuntimeException {

	public BookRoomDataIntegrityViolationException(String message, Throwable e) {
		super(message, e);
	}

}
