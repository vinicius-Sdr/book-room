package br.com.book.room.quarto.presentation.tipo.controller.swagger;

import br.com.book.room.quarto.presentation.tipo.dto.request.TipoRequest;
import br.com.book.room.quarto.presentation.tipo.dto.response.TipoResponse;
import br.com.book.room.quarto.presentation.exception.ErrorMessage;
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

@Tag(name = "Tipo", description = "Recurso para Cadastro de Tipos.")
public interface TipoControllerSwagger {

	@Operation(summary = "Criar Tipo", description = "Recurso para criar um novo Tipo.",
			responses = { @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = TipoResponse.class))) })
	ResponseEntity<TipoResponse> cadastrar(TipoRequest request, UriComponentsBuilder uriComponentsBuilder);

	@Operation(summary = "Listar todos os Tipos cadastrados",
			description = "Recursos adicionais ou comodidades oferecidas para melhorar a experiência do usuário ou cliente, como piscinas, academias, Wi-Fi gratuito, estacionamento, entre outros.",
			responses = { @ApiResponse(responseCode = "200", description = "Lista com todos os Tipos cadastrados",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = TipoResponse.class)))) })
	@PageableAsQueryParam
	ResponseEntity<Page<TipoResponse>> listarTodos(@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Recuperar um Tipo pelo id", description = "Retorna um tipo com base no ID fornecido.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = TipoResponse.class))),
					@ApiResponse(responseCode = "404", description = "Recurso não encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<TipoResponse> consultarTipoPorId(Long id);

	@Operation(summary = "Excluir tipo por ID", description = "Exclui um tipo com base no ID fornecido.",
			responses = { @ApiResponse(responseCode = "204", description = "Tipo excluído com sucesso"),
					@ApiResponse(responseCode = "404", description = "Tipo não encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "Erro interno no servidor",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<Void> excluirTipo(Long id);

	@Operation(summary = "Alterar tipo por ID", description = "Altera um tipo existente com base no ID fornecido.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Tipo alterado com sucesso",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = TipoResponse.class))),
					@ApiResponse(responseCode = "400", description = "Solicitação inválida",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "404", description = "Tipo não encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "Erro interno no servidor",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<TipoResponse> alterarTipo(Long id, TipoRequest request);

}