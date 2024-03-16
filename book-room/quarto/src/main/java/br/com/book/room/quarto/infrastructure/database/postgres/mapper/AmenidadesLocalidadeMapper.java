package br.com.book.room.quarto.infrastructure.database.postgres.mapper;

import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;
import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidadeId;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadeEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeEntityId;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.LocalidadeEntity;

public class AmenidadesLocalidadeMapper {

	public static AmenidadesLocalidade toDomain(AmenidadesLocalidadeEntity entity) {
		var amenidadesLocalidadeId = new AmenidadesLocalidadeId(entity.getId().getIdLocalidade(),
				entity.getId().getIdAmenidade());

		return new AmenidadesLocalidade(amenidadesLocalidadeId, entity.getQuantidade(),
				entity.getAmenidade().getDescricao());
	}

	public static AmenidadesLocalidadeEntity toEntity(AmenidadesLocalidade amenidadesLocalidade) {
		var amenidadesLocalidadeId = new AmenidadesLocalidadeEntityId(amenidadesLocalidade.id().idLocalidade(),
				amenidadesLocalidade.id().idAmenidade());
		var localidade = new LocalidadeEntity(amenidadesLocalidade.id().idLocalidade());
		var amenidade = new AmenidadeEntity(amenidadesLocalidade.id().idAmenidade());
		return AmenidadesLocalidadeEntity.builder()
			.id(amenidadesLocalidadeId)
			.localidade(localidade)
			.amenidade(amenidade)
			.quantidade(amenidadesLocalidade.quantidade())
			.build();
	}

}