package br.com.book.room.quarto.presentation.predio.controller.swagger;

import br.com.book.room.quarto.presentation.predio.dto.request.PredioRequest;
import br.com.book.room.quarto.presentation.predio.dto.response.PredioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Predio", description = "Recurso para Gestão de Prédios e Quartos.")
public interface PredioControllerSwagger {

    @Operation(summary = "Criar Prédio", description = "Recurso para criar um novo Prédio.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    ResponseEntity<PredioResponse> cadastrar(PredioRequest request, UriComponentsBuilder uriComponentsBuilder);

    @Operation(summary = "Listar todos os Prédios cadastrados",
            description = "Recursos para listar todos os prédios cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista com todos os Prédios cadastrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PageableAsQueryParam
    ResponseEntity<Page<PredioResponse>> listarTodos(@Parameter(hidden = true)Pageable pageable);

    @Operation(summary = "Recuperar um Prédio pelo id", description = "Retorna um prédio com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    ResponseEntity<PredioResponse> consultarPredioPorId(Long id);

    @Operation(summary = "Excluir prédio por ID", description = "Exclui um prédio com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Recurso excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    ResponseEntity<Void> excluirPredio(Long id);

    @Operation(summary = "Alterar prédio por ID", description = "Altera um prédio existente com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recurso alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    ResponseEntity<PredioResponse> alterarPredio(Long id, PredioRequest request);

}