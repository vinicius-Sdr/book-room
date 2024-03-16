package br.com.book.room.quarto.presentation.exception.swagger;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Interface para representar uma mensagem de erro")
public interface ErrorMessageSwagger {

	@Schema(description = "O caminho da requisição que gerou o erro")
	String getPath();

	@Schema(description = "O método HTTP da requisição que gerou o erro")
	String getMethod();

	@Schema(description = "O código de status HTTP do erro")
	int getStatus();

	@Schema(description = "A descrição do código de status HTTP do erro")
	String getStatusText();

	@Schema(description = "A mensagem de erro")
	String getMessage();

	@Schema(description = "Mapa de erros de validação do objeto")
	Map<String, String> getErrors();

}
