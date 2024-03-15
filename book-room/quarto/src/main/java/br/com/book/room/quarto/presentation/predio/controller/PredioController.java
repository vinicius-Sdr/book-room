package br.com.book.room.quarto.presentation.predio.controller;

import br.com.book.room.quarto.applicaton.predio.service.PredioService;
import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import br.com.book.room.quarto.presentation.predio.controller.swagger.PredioControllerSwagger;
import br.com.book.room.quarto.presentation.predio.dto.request.PredioRequest;
import br.com.book.room.quarto.presentation.predio.dto.response.PredioResponse;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(ApiRoutes.PREDIO_URI)
public class PredioController implements PredioControllerSwagger {

	private final PredioService predioService;

	public PredioController(PredioService predioService) {
		this.predioService = predioService;
	}

	@PostMapping
	@Override
	public ResponseEntity<PredioResponse> cadastrar(@Validated(CreateInfo.class) @RequestBody PredioRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		var predio = predioService.cadastrarPredio(request.toDomain());
		var uri = ApiRoutes.construirUriPredioPorId(predio.id());
		return ResponseEntity.created(uri).body(PredioResponse.fromDomain(predio));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<PredioResponse>> listarTodos(Pageable pageable) {
		var predios = predioService.consultarPredios(pageable);
		return ResponseEntity.ok(predios.map(PredioResponse::fromDomain));
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<PredioResponse> consultarPredioPorId(Long id) {
		var predio = predioService.consultarPredioPorId(id);
		return ResponseEntity.ok(PredioResponse.fromDomain(predio));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> excluirPredio(Long id) {
		predioService.deletarPredio(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<PredioResponse> alterarPredio(Long id,
			@Validated(UpdateInfo.class) @RequestBody PredioRequest request) {
		var predio = predioService.alterarPredio(id, request.toDomain());
		return ResponseEntity.ok(PredioResponse.fromDomain(predio));
	}

}