package br.com.book.room.quarto.presentation.quarto.cama.dto.request;

import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCamaId;
import br.com.book.room.quarto.presentation.quarto.cama.dto.swagger.QuartoCamaRequestSwagger;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record QuartoCamaRequest(@NotNull(groups = {
		CreateInfo.class }, message = "idQuarto é obrigatória") Long idQuarto,
		@NotNull(groups = { CreateInfo.class }, message = "idTipoCama é obrigatória") Long idTipoCama,
		@NotNull(groups = { CreateInfo.class }, message = "Quantidade é obrigatória") Integer quantidade,
		@NotEmpty(groups = { CreateInfo.class }, message = "Descrição é obrigatória") String descricao)
		implements
			QuartoCamaRequestSwagger{

	public QuartoCama fromQuartoCamaDto() {
		QuartoCamaId quartoCamaId = new QuartoCamaId(idQuarto, idTipoCama);
		return new QuartoCama(quartoCamaId, quantidade, descricao);
	}
}