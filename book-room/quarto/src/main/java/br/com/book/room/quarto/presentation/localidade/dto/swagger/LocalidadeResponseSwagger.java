package br.com.book.room.quarto.presentation.localidade.dto.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface LocalidadeResponseSwagger {

	@Schema(description = "ID da localidade")
	Long id();

	@Schema(description = "Nome da localidade")
	String nome();

	@Schema(description = "Rua/Avenida da localidade")
	String ruaAv();

	@Schema(description = "Número da localidade")
	String numero();

	@Schema(description = "CEP da localidade")
	String cep();

	@Schema(description = "Cidade da localidade")
	String cidade();

	@Schema(description = "Estado da localidade")
	String estado();

}