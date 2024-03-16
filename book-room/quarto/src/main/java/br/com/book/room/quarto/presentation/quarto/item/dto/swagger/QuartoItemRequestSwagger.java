package br.com.book.room.quarto.presentation.quarto.item.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface QuartoItemRequestSwagger {

	@Schema(description = "ID do Quarto", example = "1", required = true)
	Long idQuarto();

	@Schema(description = "Nome do item do quarto", example = "Cama", required = true)
	String nomeItem();

}