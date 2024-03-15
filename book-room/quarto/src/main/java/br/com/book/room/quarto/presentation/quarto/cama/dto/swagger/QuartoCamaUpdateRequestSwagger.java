package br.com.book.room.quarto.presentation.quarto.cama.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface QuartoCamaUpdateRequestSwagger {
    @Schema(description = "Quantidade de Camas", example = "2")
    Integer quantidade();

    @Schema(description = "Descrição do Quarto", example = "Quarto com duas camas de solteiro")
    String descricao();
}
