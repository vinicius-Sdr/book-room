package br.com.book.room.quarto.presentation.quarto.cama.dto.request;

import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import br.com.book.room.quarto.presentation.quarto.cama.dto.swagger.QuartoCamaUpdateRequestSwagger;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record QuartoCamaUpdateRequest(@NotNull(groups = {
		UpdateInfo.class }, message = "Quantidade é obrigatória") Integer quantidade,
		@NotEmpty(groups = { UpdateInfo.class }, message = "Descrição é obrigatória") String descricao)
		implements
			QuartoCamaUpdateRequestSwagger{

	public QuartoCama fromQuartoCamaDto() {

		return new QuartoCama(quantidade, descricao);
	}
}