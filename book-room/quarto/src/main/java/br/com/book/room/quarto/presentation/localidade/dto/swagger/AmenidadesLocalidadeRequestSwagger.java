package br.com.book.room.quarto.presentation.localidade.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface AmenidadesLocalidadeRequestSwagger {

	@Schema(description = "ID único que identifica a amenidade. Este ID é usado para associar a amenidade à localidade correta.",
			example = "2")
	Long idAmenidade();

	@Schema(description = "Quantidade da amenidade disponível na localidade. Este valor é usado para rastrear a quantidade de uma amenidade específica disponível em uma localidade.",
			example = "3")
	Integer quantidade();

}
