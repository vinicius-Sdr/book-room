package br.com.book.room.quarto.presentation.quarto.item.controller;

import java.net.URI;

import br.com.book.room.quarto.applicaton.quarto.item.service.QuartoItemService;
import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import br.com.book.room.quarto.presentation.quarto.item.controller.swagger.QuartoItemControllerSwagger;
import br.com.book.room.quarto.presentation.quarto.item.dto.request.QuartoItemRequest;
import br.com.book.room.quarto.presentation.quarto.item.dto.response.QuartoItemResponse;
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
@RequestMapping(ApiRoutes.QUARTO_ITEM_URI)
@Slf4j
@RequiredArgsConstructor
public class QuartoItemController implements QuartoItemControllerSwagger {

	private final QuartoItemService quartoItemService;

	@PostMapping
	@Override
	public ResponseEntity<QuartoItemResponse> cadastrar(
			@Validated(CreateInfo.class) @RequestBody QuartoItemRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		log.info("Cadastrando quarto item");

		var quartoItem = quartoItemService.cadastrarQuartoItem(request.fromQuartoItemDto());
		URI uri = ApiRoutes.construirUriQuartoItensPorId(quartoItem.id());

		return ResponseEntity.created(uri).body(QuartoItemResponse.fromQuartoItemResponse(quartoItem));
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<QuartoItemResponse> consultarQuartoItemPorId(@PathVariable Long id) {
		log.info("Buscando quarto item por id");
		var quartoItem = quartoItemService.consultarQuartoItemPorId(id);

		return ResponseEntity.ok(QuartoItemResponse.fromQuartoItemResponse(quartoItem));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> excluiQuartoItem(@PathVariable Long id) {
		log.info("Excluindo quarto item");
		quartoItemService.deletarQuartoItem(id);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	@Override
	public ResponseEntity<QuartoItemResponse> alterarQuartoItem(@PathVariable Long id,
			@Validated(UpdateInfo.class) @RequestBody QuartoItemRequest request) {
		log.info("Alterando quarto item");
		var quartoItem = quartoItemService.alterarQuartoItem(id, request.fromQuartoItemDto());

		return ResponseEntity.ok(QuartoItemResponse.fromQuartoItemResponse(quartoItem));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<QuartoItemResponse>> listarTodos(Pageable pageable) {
		log.info("Buscando todos os quartos ");
		var page = quartoItemService.consultarQuartosCama((pageable)).map(QuartoItemResponse::fromQuartoItemResponse);

		return ResponseEntity.ok(page);
	}

}