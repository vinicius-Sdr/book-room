package br.com.book.room.quarto.presentation.amenidade.controller;

import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeService;
import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import br.com.book.room.quarto.presentation.amenidade.controller.swagger.AmenidadeControllerSwagger;
import br.com.book.room.quarto.presentation.amenidade.dto.request.AmenidadeRequest;
import br.com.book.room.quarto.presentation.amenidade.dto.response.AmenidadeResponse;
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
@RequestMapping(ApiRoutes.AMENIDADE_URI)

@Slf4j
@RequiredArgsConstructor
public class AmenidadeController implements AmenidadeControllerSwagger {

	private final AmenidadeService amenidadeService;

	@PostMapping
	@Override
	public ResponseEntity<AmenidadeResponse> cadastrar(
			@Validated(CreateInfo.class) @RequestBody AmenidadeRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		log.info("Cadastrando amenidade");

		var amenidade = amenidadeService.cadastrarAmenidade(request.fromAmenidadeDto());

		var uri = ApiRoutes.construirUriAmenidadePorId(amenidade.id());

		return ResponseEntity.created(uri).body(AmenidadeResponse.fromAmenidadeResponse(amenidade));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<AmenidadeResponse>> listarTodos(Pageable pageable) {
		log.info("Buscando todas as amenidades");
		var page = amenidadeService.consultarAmenidades(pageable).map(AmenidadeResponse::fromAmenidadeResponse);

		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<AmenidadeResponse> consultarAmenidadePorId(@PathVariable Long id) {
		log.info("Buscando amenidade por id");
		var amenidadeDto = amenidadeService.consultarAmenidadePorId(id);

		return ResponseEntity.ok(AmenidadeResponse.fromAmenidadeResponse(amenidadeDto));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<AmenidadeResponse> excluiAmenidade(@PathVariable Long id) {
		log.info("Excluindo amenidade");
		amenidadeService.deletarAmenidade(id);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	@Override
	public ResponseEntity<AmenidadeResponse> alterarAmenidade(@PathVariable Long id,
			@Validated(UpdateInfo.class) @RequestBody AmenidadeRequest request) {
		log.info("Alterando amenidade");
		var amenidade = amenidadeService.alterarAmenidade(id, request.fromAmenidadeDto());

		return ResponseEntity.ok(AmenidadeResponse.fromAmenidadeResponse(amenidade));
	}

}
