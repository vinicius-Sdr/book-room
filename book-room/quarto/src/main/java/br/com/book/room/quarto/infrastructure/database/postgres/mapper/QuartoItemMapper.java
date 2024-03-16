package br.com.book.room.quarto.infrastructure.database.postgres.mapper;

import br.com.book.room.quarto.domain.core.quarto.item.QuartoItem;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemEntity;

public final class QuartoItemMapper {

	private QuartoItemMapper() {
	}

	public static QuartoItemEntity toEntity(QuartoItem quartoItem) {
		return QuartoItemEntity.builder()
			.idQuarto(quartoItem.idQuarto())
			.nomeItem(quartoItem.nomeItem())
			.quantidade(quartoItem.quantidade())
			.build();

	}

	public static QuartoItem toDomain(QuartoItemEntity savedQuartoItem) {
		return new QuartoItem(savedQuartoItem.getId(), savedQuartoItem.getIdQuarto(), savedQuartoItem.getNomeItem(),
				savedQuartoItem.getQuantidade());
	}

	public static QuartoItemEntity updateEntityFromDomain(QuartoItem quartoItem, QuartoItemEntity entity) {
		entity.setQuantidade(quartoItem.quantidade());

		if (!quartoItem.nomeItem().equalsIgnoreCase(entity.getNomeItem()))
			entity.setNomeItem(quartoItem.nomeItem());

		if (!quartoItem.idQuarto().equals(entity.getIdQuarto()))
			entity.setIdQuarto(quartoItem.idQuarto());

		return entity;
	}

}
