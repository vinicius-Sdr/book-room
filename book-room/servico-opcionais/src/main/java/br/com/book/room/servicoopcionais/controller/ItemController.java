package br.com.book.room.servicoopcionais.controller;

import br.com.book.room.servicoopcionais.model.DTO.ItemDTO;
import br.com.book.room.servicoopcionais.service.ItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping
	public ResponseEntity saveItem(@Valid @RequestBody ItemDTO itemDTO) {

		return new ResponseEntity<>(itemService.createItem(itemDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity getAllItens() {
		return ResponseEntity.ok().body(itemService.getAllItens());
	}

	@GetMapping("/{id}")
	public ResponseEntity getItemById(@Valid @PathVariable(name = "id") @NotNull Long id) {
		return ResponseEntity.ok().body(itemService.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity editItem(@Valid @PathVariable(name = "id") @NotNull Long id,
			@Valid @RequestBody ItemDTO itemDTO) throws Exception {

		return new ResponseEntity<>(itemService.editItem(id, itemDTO), HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteItem(@Valid @PathVariable(name = "id") @NotNull Long id) {
		return itemService.deleteItem(id);
	}

}
