package br.com.book.room.quarto.applicaton.exception;

public class BookRoomEntityNotFoundException extends RuntimeException {

	public BookRoomEntityNotFoundException(String message) {
		super(message);
	}

	public BookRoomEntityNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
