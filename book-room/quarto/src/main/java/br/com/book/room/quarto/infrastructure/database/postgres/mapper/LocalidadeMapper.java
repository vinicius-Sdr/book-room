package br.com.book.room.quarto.infrastructure.database.postgres.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;
import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.LocalidadeEntity;

public class LocalidadeMapper {

	public static Localidade toDomain(LocalidadeEntity entity) {
		Set<AmenidadesLocalidade> amenidades = entity.getAmenidades()
			.stream()
			.map(AmenidadesLocalidadeMapper::toDomain)
			.collect(Collectors.toSet());

		return new Localidade(entity.getId(), entity.getNome(), entity.getRuaAv(), entity.getNumero(), entity.getCep(),
				entity.getCidade(), entity.getEstado(), amenidades);
	}

	public static LocalidadeEntity toEntity(Localidade localidade) {
		return LocalidadeEntity.builder()
			.id(localidade.id())
			.nome(localidade.nome())
			.ruaAv(localidade.ruaAv())
			.numero(localidade.numero())
			.cep(localidade.cep())
			.cidade(localidade.cidade())
			.estado(localidade.estado())
			.build();
	}

}