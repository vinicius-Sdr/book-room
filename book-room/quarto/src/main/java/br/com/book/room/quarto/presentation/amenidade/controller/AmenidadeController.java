package br.com.book.room.quarto.presentation.amenidade.controller;

import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/amenidade")

@Slf4j
@RequiredArgsConstructor
public class AmenidadeController {

	private final AmenidadeService amenidadeService;

	@GetMapping
	public ResponseEntity<?> buscarAmenidades() {
		log.info("Buscando todas as amenidades");
		return ResponseEntity.ok().build();
	}

}
