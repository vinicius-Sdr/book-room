package br.com.book.room.quarto.domain.core.tipo;

import java.io.Serializable;

public record Tipo(Long id, String nome, String categoria) implements Serializable {
	public Tipo(Long idTipo) {
		this(idTipo, null, null);
	}
}