package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

public record QuartoCama(QuartoCamaId id, Quarto quarto, Tipo tipo, Integer quantidade,
		String descricao) implements Serializable {
}