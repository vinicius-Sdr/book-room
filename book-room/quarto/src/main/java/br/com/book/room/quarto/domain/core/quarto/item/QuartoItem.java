package br.com.book.room.quarto.domain.core.quarto.item;

import java.io.Serializable;

public record QuartoItem(Long id, Long idQuarto, String nomeItem, Integer quantidade) implements Serializable {
	public QuartoItem(Long idQuarto, String nomeItem, Integer quantidade) {
		this(null, idQuarto, nomeItem, quantidade);
	}
}