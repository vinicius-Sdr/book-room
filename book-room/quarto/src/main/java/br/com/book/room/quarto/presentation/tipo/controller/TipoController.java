package br.com.book.room.quarto.presentation.tipo.controller;

import br.com.book.room.quarto.applicaton.tipo.service.TipoService;
import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import br.com.book.room.quarto.presentation.tipo.controller.swagger.TipoControllerSwagger;
import br.com.book.room.quarto.presentation.tipo.dto.request.TipoRequest;
import br.com.book.room.quarto.presentation.tipo.dto.response.TipoResponse;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(ApiRoutes.TIPO_URI)
public class TipoController implements TipoControllerSwagger {

	private final TipoService tipoService;

	public TipoController(TipoService tipoService) {
		this.tipoService = tipoService;
	}

	@PostMapping
	@Override
	public ResponseEntity<TipoResponse> cadastrar(@Validated(CreateInfo.class) @RequestBody TipoRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		var tipo = tipoService.cadastrarTipo(request.toDomain());
		var uri = ApiRoutes.construirUriTipoPorId(tipo.id());
		return ResponseEntity.created(uri).body(TipoResponse.fromDomain(tipo));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<TipoResponse>> listarTodos(Pageable pageable) {
		var tipos = tipoService.consultarTipos(pageable);
		return ResponseEntity.ok(tipos.map(TipoResponse::fromDomain));
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<TipoResponse> consultarTipoPorId(Long id) {
		var tipo = tipoService.consultarTipoPorId(id);
		return ResponseEntity.ok(TipoResponse.fromDomain(tipo));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> excluirTipo(Long id) {
		tipoService.deletarTipo(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<TipoResponse> alterarTipo(Long id,
			@Validated(UpdateInfo.class) @RequestBody TipoRequest request) {
		var tipo = tipoService.alterarTipo(id, request.toDomain());
		return ResponseEntity.ok(TipoResponse.fromDomain(tipo));
	}

}