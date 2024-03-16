package br.com.book.room.quarto.presentation.localidade.dto.response;

import java.util.Set;

import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;
import br.com.book.room.quarto.presentation.localidade.dto.swagger.AmenidadesLocalidadeResponseSwagger;

public record AmenidadesLocalidadeResponse(Long idAmenidade, Integer quantidade,
		String descricao) implements AmenidadesLocalidadeResponseSwagger {

	public static Set<AmenidadesLocalidadeResponse> fromResponse(Set<AmenidadesLocalidade> amenidades) {
		return amenidades.stream()
			.map(amenidade -> new AmenidadesLocalidadeResponse(amenidade.id().idAmenidade(), amenidade.quantidade(),
					amenidade.descricao()))
			.collect(java.util.stream.Collectors.toSet());
	}

}
