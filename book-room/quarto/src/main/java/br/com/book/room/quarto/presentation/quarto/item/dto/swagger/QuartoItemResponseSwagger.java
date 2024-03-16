package br.com.book.room.quarto.presentation.quarto.item.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface QuartoItemResponseSwagger {

	@Schema(description = "ID do QuartoItem", example = "1")
	Long id();

	@Schema(description = "ID do Quarto", example = "1")
	Long idQuarto();

	@Schema(description = "Nome do item do quarto", example = "Cama")
	String nomeItem();

	@Schema(description = "Quantidade do item no quarto", example = "2")
	Integer quantidade();

}