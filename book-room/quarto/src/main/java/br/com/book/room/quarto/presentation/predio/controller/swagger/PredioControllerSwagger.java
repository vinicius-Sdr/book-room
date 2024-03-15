package br.com.book.room.quarto.presentation.predio.controller.swagger;

import br.com.book.room.quarto.presentation.predio.dto.request.PredioRequest;
import br.com.book.room.quarto.presentation.predio.dto.response.PredioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Predio", description = "Recurso para Gestão de Prédios e Quartos.")
public interface PredioControllerSwagger {

	@Operation(summary = "Criar Prédio", description = "Recurso para criar um novo Prédio.")
	ResponseEntity<PredioResponse> cadastrar(PredioRequest request, UriComponentsBuilder uriComponentsBuilder);

	@Operation(summary = "Listar todos os Prédios cadastrados",
			description = "Recursos para listar todos os prédios cadastrados.")
	ResponseEntity<Page<PredioResponse>> listarTodos(Pageable pageable);

	@Operation(summary = "Recuperar um Prédio pelo id", description = "Retorna um prédio com base no ID fornecido.")
	ResponseEntity<PredioResponse> consultarPredioPorId(Long id);

	@Operation(summary = "Excluir prédio por ID", description = "Exclui um prédio com base no ID fornecido.")
	ResponseEntity<Void> excluirPredio(Long id);

	@Operation(summary = "Alterar prédio por ID", description = "Altera um prédio existente com base no ID fornecido.")
	ResponseEntity<PredioResponse> alterarPredio(Long id, PredioRequest request);

}