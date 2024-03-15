package br.com.book.room.quarto.presentation.quarto.cama.dto.response;

import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import br.com.book.room.quarto.presentation.quarto.cama.dto.swagger.QuartoCamaResponseSwagger;

public record QuartoCamaResponse(Long idQuarto, Long idTipoCama, Integer quantidade,
		String descricao) implements QuartoCamaResponseSwagger {

	public static QuartoCamaResponse fromQuartoCamaResponse(QuartoCama quartoCama) {
		return new QuartoCamaResponse(quartoCama.id().id(), quartoCama.id().tipoCama(), quartoCama.quantidade(),
				quartoCama.descricao());
	}
}