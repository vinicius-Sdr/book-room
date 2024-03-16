package br.com.book.room.quarto.presentation.predio.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface PredioRequestSwagger {

	@Schema(description = "ID da localidade do prédio", example = "1")
	Long localidadeId();

	@Schema(description = "Nome do prédio", example = "Casa Principal")
	String nome();

}