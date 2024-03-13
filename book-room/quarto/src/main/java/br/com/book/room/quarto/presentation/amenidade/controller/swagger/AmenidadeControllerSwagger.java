package br.com.book.room.quarto.presentation.amenidade.controller.swagger;

import br.com.book.room.quarto.presentation.amenidade.dto.request.AmenidadeRequest;
import br.com.book.room.quarto.presentation.amenidade.dto.response.AmenidadeResponse;
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
            responses = {
                    @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AmenidadeResponse.class)))
            }
    )
    ResponseEntity<AmenidadeResponse> cadastrar(AmenidadeRequest request,
                                                UriComponentsBuilder uriComponentsBuilder);

    @Operation(summary = "Listar todos as Amenidades cadastrados",
			description = "Recursos adicionais ou comodidades oferecidas para melhorar a experiência do usuário ou cliente, como piscinas, academias, Wi-Fi gratuito, estacionamento, entre outros.",
			responses = { @ApiResponse(responseCode = "200", description = "Lista com todos as Amenidades cadastradas",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = AmenidadeResponse.class)))) })
	@PageableAsQueryParam
	ResponseEntity<Page<AmenidadeResponse>> listarTodos(@Parameter(hidden = true) Pageable pageable);

}
