package br.com.book.room.quarto.presentation.quarto.item.controller;

import br.com.book.room.quarto.applicaton.quarto.item.service.QuartoItemService;
import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import br.com.book.room.quarto.presentation.quarto.item.controller.swagger.QuartoItemControllerSwagger;
import br.com.book.room.quarto.presentation.quarto.item.dto.request.QuartoItemRequest;
import br.com.book.room.quarto.presentation.quarto.item.dto.response.QuartoItemResponse;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
		var uri = ApiRoutes.construirUriQuartoItensPorId(quartoItem.id());

		return ResponseEntity.created(uri).body(QuartoItemResponse.fromQuartoItemResponse(quartoItem));
	}

}
