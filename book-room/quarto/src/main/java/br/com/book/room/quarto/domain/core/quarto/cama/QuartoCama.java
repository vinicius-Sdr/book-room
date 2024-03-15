package br.com.book.room.quarto.domain.core.quarto.cama;

import java.io.Serializable;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaEntityId;

public record QuartoCama(QuartoCamaId id, Integer quantidade, String descricao) implements Serializable {
	public QuartoCama(String descricao) {
		this(null, null, descricao);
	}

	public QuartoCama(QuartoCamaEntityId id, String descricao) {
		this(null, null, descricao);
	}
}