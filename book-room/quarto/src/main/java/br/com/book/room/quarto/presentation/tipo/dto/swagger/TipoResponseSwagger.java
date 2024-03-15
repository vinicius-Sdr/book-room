package br.com.book.room.quarto.presentation.tipo.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface TipoResponseSwagger {

	@Schema(description = "ID do tipo")
	Long id();

	@Schema(description = "Nome do tipo")
	String nome();

	@Schema(description = "Categoria do tipo")
	String categoria();

}