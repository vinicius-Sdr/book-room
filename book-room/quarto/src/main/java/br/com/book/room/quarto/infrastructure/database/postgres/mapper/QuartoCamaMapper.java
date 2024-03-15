package br.com.book.room.quarto.infrastructure.database.postgres.mapper;

import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCamaId;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaEntityId;

public final class QuartoCamaMapper {

	private QuartoCamaMapper() {
	}

	public static QuartoCama toDomain(QuartoCamaEntity entity) {
		return new QuartoCama(new QuartoCamaId(entity.getId().getIdQuarto(), entity.getId().getTipoCama()),
				entity.getQuantidade(), entity.getDescricao());
	}

	public static QuartoCamaEntity toEntity(QuartoCama quartoCama) {
		var id = QuartoCamaEntityId.builder()
			.idQuarto(quartoCama.id().id())
			.tipoCama(quartoCama.id().tipoCama())
			.build();

		return QuartoCamaEntity.builder()
			.quantidade(quartoCama.quantidade())
			.descricao(quartoCama.descricao())
			.id(id)
			.build();

	}

	public static QuartoCamaEntity updateEntityFromDomain(QuartoCama quartoCama, QuartoCamaEntity entity) {
		entity.setQuantidade(quartoCama.quantidade());
		entity.setDescricao(quartoCama.descricao());
		return entity;
	}

}