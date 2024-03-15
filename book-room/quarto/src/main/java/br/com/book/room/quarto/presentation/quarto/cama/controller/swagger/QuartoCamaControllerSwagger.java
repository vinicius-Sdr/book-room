package br.com.book.room.quarto.presentation.quarto.cama.controller.swagger;

import br.com.book.room.quarto.presentation.exception.ErrorMessage;
import br.com.book.room.quarto.presentation.quarto.cama.dto.request.QuartoCamaRequest;
import br.com.book.room.quarto.presentation.quarto.cama.dto.response.QuartoCamaResponse;
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

@Tag(name = "QuartoCama", description = "Recurso para Cadastro de QuartosCama.")
public interface QuartoCamaControllerSwagger {

	@Operation(summary = "Criar QuartoCama", description = "Recurso para criar um novo QuartoCama.",
			responses = { @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = QuartoCamaResponse.class))) })
	ResponseEntity<QuartoCamaResponse> cadastrar(QuartoCamaRequest request, UriComponentsBuilder uriComponentsBuilder);

	@Operation(summary = "Listar todos os QuartosCama cadastrados",
			description = "Recursos adicionais ou comodidades oferecidas para melhorar a experiência do usuário ou cliente, como piscinas, academias, Wi-Fi gratuito, estacionamento, entre outros.",
			responses = { @ApiResponse(responseCode = "200", description = "Lista com todos os QuartosCama cadastrados",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = QuartoCamaResponse.class)))) })
	@PageableAsQueryParam
	ResponseEntity<Page<QuartoCamaResponse>> listarTodos(@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Recuperar um QuartoCama pelo id",
			description = "Retorna um QuartoCama com base no ID fornecido.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = QuartoCamaResponse.class))),
					@ApiResponse(responseCode = "404", description = "Recurso não encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<QuartoCamaResponse> consultarQuartoCamaPorId(
			@Parameter(description = "ID do QuartoCama a ser buscado", required = true) Long idQuarto,
			@Parameter(description = "ID do QuartoCama a ser buscado", required = true) Long idTipoCama);

	@Operation(summary = "Excluir QuartoCama por ID", description = "Exclui um QuartoCama com base no ID fornecido.",
			responses = { @ApiResponse(responseCode = "204", description = "QuartoCama excluído com sucesso"),
					@ApiResponse(responseCode = "404", description = "QuartoCama não encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "Erro interno no servidor",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<Void> excluiQuartoCama(
			@Parameter(description = "ID do QuartoCama a ser excluído", required = true) Long idQuarto,
			@Parameter(description = "ID do QuartoCama a ser excluído", required = true) Long idTipoCama);

	@Operation(summary = "Alterar QuartoCama por ID",
			description = "Altera um QuartoCama existente com base no ID fornecido.",
			responses = {
					@ApiResponse(responseCode = "200", description = "QuartoCama alterado com sucesso",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = QuartoCamaResponse.class))),
					@ApiResponse(responseCode = "400", description = "Solicitação inválida",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "404", description = "QuartoCama não encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "Erro interno no servidor",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<QuartoCamaResponse> alterarQuartoCama(
			@Parameter(description = "ID do QuartoCama a ser alterado", required = true) Long idQuarto,
			@Parameter(description = "ID do QuartoCama a ser alterado", required = true) Long idTipoCama,
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados do QuartoCama para atualização",
					required = true) QuartoCamaRequest request);

}