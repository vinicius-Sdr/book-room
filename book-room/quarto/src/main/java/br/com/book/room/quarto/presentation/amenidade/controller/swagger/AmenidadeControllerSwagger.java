package br.com.book.room.quarto.presentation.amenidade.controller.swagger;

import br.com.book.room.quarto.presentation.amenidade.dto.request.AmenidadeRequest;
import br.com.book.room.quarto.presentation.amenidade.dto.response.AmenidadeResponse;
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

@Tag(name = "Amenidade", description = "Recurso para Cadastro de Amenidades.")
public interface AmenidadeControllerSwagger {

	@Operation(summary = "Criar Amenidade", description = "Recurso para criar uma nova Amenidade.",
			responses = { @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = AmenidadeResponse.class))) })
	ResponseEntity<AmenidadeResponse> cadastrar(AmenidadeRequest request, UriComponentsBuilder uriComponentsBuilder);

	@Operation(summary = "Listar todos as Amenidades cadastrados",
			description = "Recursos adicionais ou comodidades oferecidas para melhorar a experiência do usuário ou cliente, como piscinas, academias, Wi-Fi gratuito, estacionamento, entre outros.",
			responses = { @ApiResponse(responseCode = "200", description = "Lista com todos as Amenidades cadastradas",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = AmenidadeResponse.class)))) })
	@PageableAsQueryParam
	ResponseEntity<Page<AmenidadeResponse>> listarTodos(@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Recuperar um Amenidade pelo id",
			description = "Retorna uma amenidade com base no ID fornecido.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = AmenidadeResponse.class))),
					@ApiResponse(responseCode = "404", description = "Recurso não encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<AmenidadeResponse> consultarAmenidadePorId(
			@Parameter(description = "ID da amenidade a ser buscada", required = true) Long id);

	@Operation(summary = "Excluir amenidade por ID", description = "Exclui uma amenidade com base no ID fornecido.",
			responses = { @ApiResponse(responseCode = "204", description = "Amenidade excluída com sucesso"),
					@ApiResponse(responseCode = "404", description = "Amenidade não encontrada",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "Erro interno no servidor",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<AmenidadeResponse> excluiAmenidade(
			@Parameter(description = "ID da amenidade a ser excluída", required = true) Long id);

	@Operation(summary = "Alterar amenidade por ID",
			description = "Altera uma amenidade existente com base no ID fornecido.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Amenidade alterada com sucesso",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = AmenidadeResponse.class))),
					@ApiResponse(responseCode = "400", description = "Solicitação inválida",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "404", description = "Amenidade não encontrada",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "Erro interno no servidor",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ErrorMessage.class))) })
	ResponseEntity<AmenidadeResponse> alterarAmenidade(
			@Parameter(description = "ID da amenidade a ser alterada", required = true) Long id,
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados da amenidade para atualização",
					required = true) AmenidadeRequest request);

}
