package br.com.book.room.reservas.controller;

import br.com.book.room.reservas.model.dto.ReservaDTO;
import br.com.book.room.reservas.service.ReservaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@PostMapping
	public ResponseEntity saveReserva(@Valid @RequestBody ReservaDTO reservaDTO) {
		return new ResponseEntity<>(reservaService.createReserva(reservaDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity getAllItens() {
		return ResponseEntity.ok().body(reservaService.getAllReservas());
	}

	@GetMapping("/{id}")
	public ResponseEntity getReservaById(@Valid @PathVariable(name = "id") @NotNull Long id) {
		return ResponseEntity.ok().body(reservaService.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity editReserva(@Valid @PathVariable(name = "id") @NotNull Long id,
			@Valid @RequestBody ReservaDTO reservaDTO) throws Exception {
		return new ResponseEntity<>(reservaService.editReserva(id, reservaDTO), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteReserva(@Valid @PathVariable(name = "id") @NotNull Long id) {
		return reservaService.deleteReserva(id);
	}

}
