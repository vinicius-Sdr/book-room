package br.com.book.room.quarto.presentation.quarto.cama.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface QuartoCamaResponseSwagger {

	@Schema(description = "ID do Quarto", example = "1")
	Long idQuarto();

	@Schema(description = "ID do Tipo de Cama", example = "2")
	Long idTipoCama();

	@Schema(description = "Quantidade de Camas", example = "2")
	Integer quantidade();

	@Schema(description = "Descrição do Quarto", example = "Quarto com duas camas de solteiro")
	String descricao();

}