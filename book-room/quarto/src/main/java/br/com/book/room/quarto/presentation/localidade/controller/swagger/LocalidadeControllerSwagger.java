package br.com.book.room.quarto.presentation.localidade.controller.swagger;

import br.com.book.room.quarto.presentation.exception.ErrorMessage;
import br.com.book.room.quarto.presentation.localidade.dto.request.LocalidadeRequest;
import br.com.book.room.quarto.presentation.localidade.dto.response.LocalidadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Localidade", description = "Recurso para Cadastro de Localidades.")
public interface LocalidadeControllerSwagger {

	@Operation(summary = "Criar Localidade", description = "Recurso para criar uma nova Localidade.",
			responses = { @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = LocalidadeResponse.class))) })
	ResponseEntity<LocalidadeResponse> cadastrar(LocalidadeRequest request, UriComponentsBuilder uriComponentsBuilder);

	@Operation(summary = "Listar todas as Localidades cadastradas",
			description = "Recursos adicionais ou comodidades oferecidas para melhorar a experiência do usuário ou cliente, como piscinas, academias, Wi-Fi gratuito, estacionamento, entre outros.",
			responses = { @ApiResponse(responseCode = "200", description = "Lista com todas as Localidades cadastradas",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = LocalidadeResponse.class)))) })
	@PageableAsQueryParam
	ResponseEntity<Page<LocalidadeResponse>> listarTodos(@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Recuperar uma Localidade pelo id",
			description = "Retorna uma localidade com base no ID fornecido.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = LocalidadeResponse.class))),
					@ApiResponse(responseCode = "404", description = "Recurso não encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<LocalidadeResponse> consultarLocalidadePorId(
			@Parameter(description = "ID da localidade a ser buscada", required = true) Long id);

	@Operation(summary = "Excluir localidade por ID", description = "Exclui uma localidade com base no ID fornecido.",
			responses = { @ApiResponse(responseCode = "204", description = "Localidade excluída com sucesso"),
					@ApiResponse(responseCode = "404", description = "Localidade não encontrada",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "Erro interno no servidor",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<Void> excluirLocalidade(
			@Parameter(description = "ID da localidade a ser excluída", required = true) Long id);

	@Operation(summary = "Alterar localidade por ID",
			description = "Altera uma localidade existente com base no ID fornecido.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Localidade alterada com sucesso",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = LocalidadeResponse.class))),
					@ApiResponse(responseCode = "400", description = "Solicitação inválida",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "404", description = "Localidade não encontrada",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "Erro interno no servidor",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<LocalidadeResponse> alterarLocalidade(
			@Parameter(description = "ID da localidade a ser alterada", required = true) Long id,
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados da localidade para atualização",
					required = true) LocalidadeRequest request);

}