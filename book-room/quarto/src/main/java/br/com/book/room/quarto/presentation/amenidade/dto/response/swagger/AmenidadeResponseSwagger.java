package br.com.book.room.quarto.presentation.amenidade.dto.response.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface AmenidadeResponseSwagger {

	@Schema(description = "ID da amenidade")
	Long id();

	@Schema(description = "Descrição da amenidade")
	String descricao();

}
