package br.com.book.room.quarto.presentation.amenidade.dto.response.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface AmenidadeRequestSwagger {

	@Schema(description = "Descrição da amenidade", example = "Piscina Adulto, aquecida e coberta")
	String descricao();

}
