package br.com.book.room.quarto.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CheckController {

	@GetMapping
	public String check() {
		return "OK";
	}

}
