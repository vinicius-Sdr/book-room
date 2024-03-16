package br.com.book.room.quarto.presentation.quarto.item.dto.response;

import br.com.book.room.quarto.domain.core.quarto.item.QuartoItem;
import br.com.book.room.quarto.presentation.quarto.item.dto.swagger.QuartoItemResponseSwagger;

public record QuartoItemResponse(Long id, Long idQuarto, String nomeItem, Integer quantidade

) implements QuartoItemResponseSwagger {

	public static QuartoItemResponse fromQuartoItemResponse(QuartoItem quartoItem) {

		return new QuartoItemResponse(quartoItem.id(), quartoItem.idQuarto(), quartoItem.nomeItem(),
				quartoItem.quantidade());
	}
}
