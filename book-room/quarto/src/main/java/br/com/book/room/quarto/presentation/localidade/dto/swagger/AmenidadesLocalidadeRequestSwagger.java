package br.com.book.room.quarto.presentation.localidade.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface AmenidadesLocalidadeRequestSwagger {

    @Schema(description = "ID único que identifica a localidade. Este ID é usado para associar a amenidade à localidade correta.",
            example = "1 - ID que representa a Fazenda da Pós Tech no sistema.")
    Long idLocalidade();

    @Schema(description = "ID único que identifica a amenidade. Este ID é usado para associar a amenidade à localidade correta.",
            example = "2 - ID que representa a amenidade 'Piscina Adulto, não aquecida em área aberta' no sistema.")
    Long idAmenidade();

    @Schema(description = "Quantidade da amenidade disponível na localidade. Este valor é usado para rastrear a quantidade de uma amenidade específica disponível em uma localidade.",
            example = "3 - Indica que existem 3 unidades da amenidade 'Piscina Adulto, não aquecida em área aberta' disponíveis na localidade 'Fazenda da Pós Tech'.")
    Integer quantidade();

}