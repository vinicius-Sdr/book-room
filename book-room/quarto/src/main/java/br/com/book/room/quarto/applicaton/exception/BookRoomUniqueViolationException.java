package br.com.book.room.quarto.applicaton.exception;

public class BookRoomUniqueViolationException extends RuntimeException {

	public BookRoomUniqueViolationException(String message, Throwable e) {
		super(message, e);
	}

	public BookRoomUniqueViolationException(String message) {
		super(message);
	}

}
