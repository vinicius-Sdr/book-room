package br.com.book.room.quarto.presentation.quarto;

import java.net.URI;

import br.com.book.room.quarto.applicaton.quarto.QuartoService;
import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import br.com.book.room.quarto.presentation.quarto.dto.request.QuartoRequest;
import br.com.book.room.quarto.presentation.quarto.dto.response.QuartoResponse;
import br.com.book.room.quarto.presentation.quarto.swagger.QuartoControllerSwagger;
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
@RequestMapping(ApiRoutes.QUARTO_URI)
@Slf4j
@RequiredArgsConstructor
public class QuartoController implements QuartoControllerSwagger {

	private final QuartoService quartoService;

	@PostMapping
	@Override
	public ResponseEntity<QuartoResponse> cadastrar(@Validated(CreateInfo.class) @RequestBody QuartoRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		log.info("Cadastrando quarto ");

		var quarto = quartoService.cadastrarQuarto(request.fromQuartoDto());
		URI uri = ApiRoutes.construirUriQuartoItensPorId(quarto.id());

		return ResponseEntity.created(uri).body(QuartoResponse.fromQuartoResponse(quarto));
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<QuartoResponse> consultarQuartoPorId(@PathVariable Long id) {
		log.info("Buscando quarto  por id");
		var quarto = quartoService.consultarQuartoPorId(id);

		return ResponseEntity.ok(QuartoResponse.fromQuartoResponse(quarto));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> excluiQuarto(@PathVariable Long id) {
		log.info("Excluindo quarto ");
		quartoService.deletarQuarto(id);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	@Override
	public ResponseEntity<QuartoResponse> alterarQuarto(@PathVariable Long id,
			@Validated(UpdateInfo.class) @RequestBody QuartoRequest request) {
		log.info("Alterando quarto ");
		var quarto = quartoService.alterarQuarto(id, request.fromQuartoDto());

		return ResponseEntity.ok(QuartoResponse.fromQuartoResponse(quarto));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<QuartoResponse>> listarTodos(Pageable pageable) {
		log.info("Buscando todos os quartos ");
		var page = quartoService.consultarQuartos(pageable).map(QuartoResponse::fromQuartoResponse);

		return ResponseEntity.ok(page);
	}

}