package br.com.book.room.quarto.presentation.localidade.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface LocalidadeRequestSwagger {

	@Schema(description = "Nome da localidade", example = "Fazenda da Pós Tech")
	String nome();

	@Schema(description = "Rua/Avenida da localidade", example = "Rua da Pós Tech, 567")
	String ruaAv();

	@Schema(description = "Número da localidade", example = "123")
	String numero();

	@Schema(description = "CEP da localidade", example = "01000-002")
	String cep();

	@Schema(description = "Cidade da localidade", example = "Cidade da Pós Tech")
	String cidade();

	@Schema(description = "Estado da localidade", example = "Estado da Pós Tech")
	String estado();

}