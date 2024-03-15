package br.com.book.room.quarto.presentation.localidade.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface AmenidadesLocalidadeResponseSwagger {

	@Schema(description = "ID da amenidade")
	Long idAmenidade();

	@Schema(description = "Quantidade da amenidade")
	Integer quantidade();

	@Schema(description = "Descrição da amenidade")
	String descricao();

}