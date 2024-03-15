package br.com.book.room.quarto.presentation.localidade.controller;

import static br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes.LOCALIDADE_URI;

import br.com.book.room.quarto.applicaton.localidade.service.LocalidadeService;
import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import br.com.book.room.quarto.presentation.localidade.controller.swagger.LocalidadeControllerSwagger;
import br.com.book.room.quarto.presentation.localidade.dto.request.LocalidadeRequest;
import br.com.book.room.quarto.presentation.localidade.dto.response.LocalidadeResponse;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(LOCALIDADE_URI)
@Slf4j
public class LocalidadeController implements LocalidadeControllerSwagger {

	private final LocalidadeService localidadeService;

	public LocalidadeController(LocalidadeService localidadeService) {
		this.localidadeService = localidadeService;
	}

	@PostMapping
	@Override
	public ResponseEntity<LocalidadeResponse> cadastrar(@Validated(CreateInfo.class) @RequestBody LocalidadeRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		log.info("Cadastrando localidade");
		var localidade = localidadeService.cadastrarLocalidade(request.toDomain());
		var uri = ApiRoutes.construirUriLocalidadePorId(localidade.id());

		return ResponseEntity.created(uri).body(LocalidadeResponse.fromResponse(localidade));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<LocalidadeResponse>> listarTodos(Pageable pageable) {
		log.info("Buscando todas as localidades");
		var localidades = localidadeService.consultarLocalidades(pageable);

		return ResponseEntity.ok(localidades.map(LocalidadeResponse::fromResponse));
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<LocalidadeResponse> consultarLocalidadePorId(@PathVariable Long id) {
		log.info("Buscando localidade por id");
		var localidade = localidadeService.consultarLocalidadePorId(id);
		return ResponseEntity.ok(LocalidadeResponse.fromResponse(localidade));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> excluirLocalidade(@PathVariable Long id) {
		log.info("Excluindo localidade por id");
		localidadeService.deletarLocalidade(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<LocalidadeResponse> alterarLocalidade(@PathVariable Long id,
																@Validated(UpdateInfo.class) @RequestBody LocalidadeRequest request) {
		log.info("Alterando localidade por id");
		var localidade = localidadeService.alterarLocalidade(id, request.toDomain());
		return ResponseEntity.ok(LocalidadeResponse.fromResponse(localidade));
	}

}