package br.com.book.room.quarto.presentation.quarto.item.dto.request;

import br.com.book.room.quarto.domain.core.quarto.item.QuartoItem;
import br.com.book.room.quarto.presentation.quarto.item.dto.swagger.QuartoItemRequestSwagger;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import jakarta.validation.constraints.NotNull;

public record QuartoItemRequest(@NotNull(groups = {
		CreateInfo.class }, message = "id do quarto é obrigatória") Long idQuarto,
		@NotNull(groups = { CreateInfo.class }, message = "Nome do item do quarto é obrigatória") String nomeItem,
		@NotNull(groups = { CreateInfo.class }, message = "Quantidade é obrigatória") Integer Quantidade)
		implements
			QuartoItemRequestSwagger{

	public QuartoItem fromQuartoItemDto() {

		return new QuartoItem(idQuarto, nomeItem, Quantidade);

	}
}
