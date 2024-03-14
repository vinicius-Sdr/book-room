package br.com.book.room.quarto.infrastructure.database.postgres.mapper;

import br.com.book.room.quarto.domain.core.amenidade.Amenidade;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadeEntity;

public final class AmenidadeMapper {

	private AmenidadeMapper() {
	}

	public static Amenidade toDomain(AmenidadeEntity entity) {
		if (entity.getId() == null) {
			return new Amenidade(entity.getDescricao());
		}
		else {
			return new Amenidade(entity.getId(), entity.getDescricao());
		}
	}

	public static AmenidadeEntity toEntity(Amenidade amenidade) {
		if (amenidade.id() == null) {
			return AmenidadeEntity.builder().descricao(amenidade.descricao()).build();
		}
		else {
			return AmenidadeEntity.builder().id(amenidade.id()).descricao(amenidade.descricao()).build();
		}
	}

}
