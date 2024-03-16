package br.com.book.room.quarto.presentation.predio.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface PredioResponseSwagger {

	@Schema(description = "ID do prédio")
	Long id();

	@Schema(description = "ID da localidade do prédio")
	Long localidadeId();

	@Schema(description = "Nome do prédio")
	String nome();

}