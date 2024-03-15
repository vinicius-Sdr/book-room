package br.com.book.room.quarto.presentation.quarto.cama.dto.request;

import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCamaId;
import br.com.book.room.quarto.presentation.quarto.cama.dto.swagger.QuartoCamaRequestSwagger;

public record QuartoCamaRequest(Long idQuarto, Long idTipoCama, Integer quantidade,
		String descricao) implements QuartoCamaRequestSwagger {

	public QuartoCama fromQuartoCamaDto() {
		QuartoCamaId quartoCamaId = new QuartoCamaId(idQuarto, idTipoCama);
		return new QuartoCama(quartoCamaId, quantidade, descricao);
	}
}