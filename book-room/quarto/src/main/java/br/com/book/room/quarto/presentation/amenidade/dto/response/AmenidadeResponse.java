package br.com.book.room.quarto.presentation.amenidade.dto.response;

import br.com.book.room.quarto.domain.core.amenidade.Amenidade;
import br.com.book.room.quarto.presentation.amenidade.dto.response.swagger.AmenidadeResponseSwagger;

public record AmenidadeResponse(Long id, String descricao) implements AmenidadeResponseSwagger {

	public static AmenidadeResponse fromAmenidadeResponse(Amenidade amenidade) {
		return new AmenidadeResponse(amenidade.id(), amenidade.descricao());
	}
}
