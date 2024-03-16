package br.com.book.room.servicoopcionais.controller;

import br.com.book.room.servicoopcionais.model.DTO.ServicingDTO;
import br.com.book.room.servicoopcionais.service.ServicingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/servicing")
public class ServicingController {

	@Autowired
	private ServicingService servicingService;

	@PostMapping
	public ResponseEntity saveServicing(@Valid @RequestBody ServicingDTO servicingDTO) {

		return new ResponseEntity<>(servicingService.createService(servicingDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity getAllItens() {
		return ResponseEntity.ok().body(servicingService.getAllServices());
	}

	@GetMapping("/{id}")
	public ResponseEntity getServicingById(@Valid @PathVariable(name = "id") @NotNull Long id) {
		return ResponseEntity.ok().body(servicingService.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity editServicing(@Valid @PathVariable(name = "id") @NotNull Long id,
			@Valid @RequestBody ServicingDTO servicingDTO) throws Exception {

		return new ResponseEntity<>(servicingService.editService(id, servicingDTO), HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteServicing(@Valid @PathVariable(name = "id") @NotNull Long id) {
		return servicingService.deleteService(id);
	}

}
