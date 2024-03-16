package br.com.book.room.quarto.presentation.quarto.item.controller.swagger;

import br.com.book.room.quarto.presentation.quarto.item.dto.request.QuartoItemRequest;
import br.com.book.room.quarto.presentation.quarto.item.dto.response.QuartoItemResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "QuartoItem", description = "Recurso para Cadastro de QuartosItem.")
public interface QuartoItemControllerSwagger {

	@Operation(summary = "Criar QuartoItem", description = "Recurso para criar um novo QuartoItem.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = QuartoItemResponse.class))),
			@ApiResponse(responseCode = "400", description = "Solicitação inválida"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	ResponseEntity<QuartoItemResponse> cadastrar(QuartoItemRequest request, UriComponentsBuilder uriComponentsBuilder);

	@Operation(summary = "Consultar QuartoItem por ID", description = "Retorna um QuartoItem com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = QuartoItemResponse.class))),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	ResponseEntity<QuartoItemResponse> consultarQuartoItemPorId(Long id);

	@Operation(summary = "Excluir QuartoItem por ID", description = "Exclui um QuartoItem com base no ID fornecido.")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Recurso excluído com sucesso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	ResponseEntity<Void> excluiQuartoItem(Long id);

	@Operation(summary = "Alterar QuartoItem por ID",
			description = "Altera um QuartoItem existente com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Recurso alterado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = QuartoItemResponse.class))),
			@ApiResponse(responseCode = "400", description = "Solicitação inválida"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	ResponseEntity<QuartoItemResponse> alterarQuartoItem(Long id, QuartoItemRequest request);

	@Operation(summary = "Listar todos os QuartosCama cadastrados",
			description = "Retorna uma lista com todos os QuartosCama cadastrados.",
			responses = { @ApiResponse(responseCode = "200", description = "Lista com todos os QuartosCama cadastrados",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = QuartoItemRequest.class)))) })
	@PageableAsQueryParam
	ResponseEntity<Page<QuartoItemResponse>> listarTodos(@Parameter(hidden = true) Pageable pageable);

}