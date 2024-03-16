package br.com.book.room.clientes.controller;

import br.com.book.room.clientes.model.DTO.ClientDTO;
import br.com.book.room.clientes.service.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping
	public ResponseEntity saveClient(@Valid @RequestBody ClientDTO clientDTO) {
		ResponseEntity<String> BAD_REQUEST = validateNacionality(clientDTO);
		if (BAD_REQUEST != null)
			return BAD_REQUEST;
		return new ResponseEntity<>(clientService.createClient(clientDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity getAllClients() {
		return ResponseEntity.ok().body(clientService.getAllClients());
	}

	@GetMapping("/{id}")
	public ResponseEntity getClientById(@Valid @PathVariable(name = "id") @NotNull Long id) {
		return ResponseEntity.ok().body(clientService.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity editClient(@Valid @PathVariable(name = "id") @NotNull Long id,
			@Valid @RequestBody ClientDTO clientDTO) throws Exception {

		ResponseEntity<String> BAD_REQUEST = validateNacionality(clientDTO);
		if (BAD_REQUEST != null)
			return BAD_REQUEST;
		return new ResponseEntity<>(clientService.editClient(id, clientDTO), HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteClient(@Valid @PathVariable(name = "id") @NotNull Long id) {
		return clientService.deleteClient(id);
	}

	private static ResponseEntity<String> validateNacionality(ClientDTO clientDTO) {
		if (clientDTO.getCountry().equalsIgnoreCase("Brasil")) {
			if (clientDTO.getCPF() == null) {
				return new ResponseEntity<>("CPF é obrigatório", HttpStatus.BAD_REQUEST);
			}
		}
		else {
			if (clientDTO.getPassport().isEmpty()) {
				return new ResponseEntity<>("Número de passaporte é obrigatório para estrangeiros",
						HttpStatus.BAD_REQUEST);
			}
		}
		return null;
	}

}
