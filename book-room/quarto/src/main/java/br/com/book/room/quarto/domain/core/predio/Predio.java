package br.com.book.room.quarto.domain.core.predio;

import java.io.Serializable;

import br.com.book.room.quarto.domain.core.localidade.Localidade;

public record Predio(Long id, Localidade localidade, String nome) implements Serializable {
	public Predio(Long idPredio) {
		this(idPredio, null, null);
	}
}