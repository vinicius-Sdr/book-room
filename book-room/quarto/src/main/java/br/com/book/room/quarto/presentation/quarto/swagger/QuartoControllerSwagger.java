package br.com.book.room.quarto.presentation.quarto.swagger;


import br.com.book.room.quarto.presentation.quarto.dto.request.QuartoRequest;
import br.com.book.room.quarto.presentation.quarto.dto.response.QuartoResponse;
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

@Tag(name = "Quarto", description = "Recurso para Cadastro de Quartos.")
public interface QuartoControllerSwagger {

	@Operation(summary = "Criar Quarto", description = "Recurso para criar um novo Quarto.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = QuartoResponse.class))),
			@ApiResponse(responseCode = "400", description = "Solicitação inválida"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	ResponseEntity<QuartoResponse> cadastrar(QuartoRequest request, UriComponentsBuilder uriComponentsBuilder);

	@Operation(summary = "Consultar Quarto por ID", description = "Retorna um Quarto com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = QuartoResponse.class))),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	ResponseEntity<QuartoResponse> consultarQuartoPorId(Long id);

	@Operation(summary = "Excluir Quarto por ID", description = "Exclui um Quarto com base no ID fornecido.")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Recurso excluído com sucesso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	ResponseEntity<Void> excluiQuarto(Long id);

	@Operation(summary = "Alterar Quarto por ID",
			description = "Altera um Quarto existente com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Recurso alterado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = QuartoResponse.class))),
			@ApiResponse(responseCode = "400", description = "Solicitação inválida"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	ResponseEntity<QuartoResponse> alterarQuarto(Long id, QuartoRequest request);


	@Operation(summary = "Listar todos os QuartosCama cadastrados",
			description = "Retorna uma lista com todos os QuartosCama cadastrados.",
			responses = { @ApiResponse(responseCode = "200", description = "Lista com todos os QuartosCama cadastrados",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = QuartoResponse.class)))) })
	@PageableAsQueryParam
    ResponseEntity<Page<QuartoResponse>> listarTodos(@Parameter(hidden = true) Pageable pageable);
}