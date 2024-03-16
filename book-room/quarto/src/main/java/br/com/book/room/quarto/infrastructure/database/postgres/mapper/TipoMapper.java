package br.com.book.room.quarto.infrastructure.database.postgres.mapper;

import br.com.book.room.quarto.domain.core.tipo.Tipo;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.TipoEntity;

public class TipoMapper {

	public static Tipo toDomain(TipoEntity entity) {
		return new Tipo(entity.getId(), entity.getNome(), entity.getCategoria());
	}

	public static TipoEntity toEntity(Tipo tipo) {
		return TipoEntity.builder().id(tipo.id()).nome(tipo.nome()).categoria(tipo.categoria()).build();
	}

}