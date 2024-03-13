package br.com.book.room.quarto.presentation.amenidade.controller;

import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeService;
import br.com.book.room.quarto.presentation.amenidade.controller.swagger.AmenidadeControllerSwagger;
import br.com.book.room.quarto.presentation.amenidade.dto.request.AmenidadeRequest;
import br.com.book.room.quarto.presentation.amenidade.dto.response.AmenidadeResponse;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/amenidade")

@Slf4j
@RequiredArgsConstructor
public class AmenidadeController implements AmenidadeControllerSwagger {

	private final AmenidadeService amenidadeService;

	@PostMapping
	@Override
	public ResponseEntity<AmenidadeResponse> cadastrar(@Validated(CreateInfo.class) @RequestBody AmenidadeRequest request,
													   UriComponentsBuilder uriComponentsBuilder) {
		log.info("Cadastrando amenidade");

		var amenidade = amenidadeService.cadastrarAmenidade(request.fromAmenidadeDto());

		var uri = uriComponentsBuilder.path("/api/v1/amenidade/{id}").buildAndExpand(amenidade.id()).toUri();

		return ResponseEntity.created(uri).body(AmenidadeResponse.fromAmenidadeResponse(amenidade));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<AmenidadeResponse>> listarTodos(Pageable pageable) {
		log.info("Buscando todas as amenidades");
		var page = amenidadeService.consultarAmenidades(pageable).map(AmenidadeResponse::fromAmenidadeResponse);

		return ResponseEntity.ok(page);
	}

}
