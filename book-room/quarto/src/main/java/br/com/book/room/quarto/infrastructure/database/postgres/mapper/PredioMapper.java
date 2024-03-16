package br.com.book.room.quarto.infrastructure.database.postgres.mapper;

import br.com.book.room.quarto.domain.core.predio.Predio;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.LocalidadeEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.PredioEntity;

public class PredioMapper {

	public static Predio toDomain(PredioEntity entity) {
		return new Predio(entity.getId(), LocalidadeMapper.toDomain(entity.getLocalidade()), entity.getNome());
	}

	public static PredioEntity toEntity(Predio predio) {
		LocalidadeEntity localidadeEntity = LocalidadeMapper.toEntity(predio.localidade());
		return PredioEntity.builder().id(predio.id()).localidade(localidadeEntity).nome(predio.nome()).build();
	}

}