package br.com.book.room.quarto.applicaton.validacao;

import br.com.book.room.quarto.applicaton.validacao.exception.ValidationException;

/**
 * @param <T>
 */
public interface Validador<T> {

	/**
	 * @param entidade entidade a ser validada
	 * @throws ValidationException
	 */
	void validar(T entidade) throws ValidationException;

}
