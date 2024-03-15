package br.com.book.room.quarto.presentation.quarto.cama.controller;

import java.util.Map;

import br.com.book.room.quarto.applicaton.quarto.cama.service.QuartoCamaService;
import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import br.com.book.room.quarto.presentation.quarto.cama.controller.swagger.QuartoCamaControllerSwagger;
import br.com.book.room.quarto.presentation.quarto.cama.dto.request.QuartoCamaRequest;
import br.com.book.room.quarto.presentation.quarto.cama.dto.response.QuartoCamaResponse;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(ApiRoutes.QUARTO_CAMA_URI)
@Slf4j
@RequiredArgsConstructor
public class QuartoCamaController implements QuartoCamaControllerSwagger {

	private final QuartoCamaService quartoCamaService;

	@PostMapping
	@Override
	public ResponseEntity<QuartoCamaResponse> cadastrar(
			@Validated(CreateInfo.class) @RequestBody QuartoCamaRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		log.info("Cadastrando quarto cama");

		var quartoCama = quartoCamaService.cadastrarQuartoCama(request.fromQuartoCamaDto());

		var uri = ApiRoutes.construirUriQuartoCamaPorId(
				Map.of("idQuarto", quartoCama.id().id(), "idTipo", quartoCama.id().tipoCama()));

		return ResponseEntity.created(uri).body(QuartoCamaResponse.fromQuartoCamaResponse(quartoCama));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<QuartoCamaResponse>> listarTodos(Pageable pageable) {
		log.info("Buscando todos os quartos cama");
		var page = quartoCamaService.consultarQuartosCama(pageable).map(QuartoCamaResponse::fromQuartoCamaResponse);

		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<QuartoCamaResponse> consultarQuartoCamaPorId(@PathVariable Long id) {
		log.info("Buscando quarto cama por id");
		var quartoCamaDto = quartoCamaService.consultarQuartoCamaPorId(id);

		return ResponseEntity.ok(QuartoCamaResponse.fromQuartoCamaResponse(quartoCamaDto));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> excluiQuartoCama(@PathVariable Long id) {
		log.info("Excluindo quarto cama");
		quartoCamaService.deletarQuartoCama(id);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	@Override
	public ResponseEntity<QuartoCamaResponse> alterarQuartoCama(@PathVariable Long id,
			@Validated(UpdateInfo.class) @RequestBody QuartoCamaRequest request) {
		log.info("Alterando quarto cama");
		var quartoCama = quartoCamaService.alterarQuartoCama(id, request.fromQuartoCamaDto());

		return ResponseEntity.ok(QuartoCamaResponse.fromQuartoCamaResponse(quartoCama));
	}

}