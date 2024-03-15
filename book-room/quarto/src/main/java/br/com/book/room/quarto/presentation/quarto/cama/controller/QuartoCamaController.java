package br.com.book.room.quarto.presentation.quarto.cama.controller;

import static br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes.QUARTO_CAMA_URI;

import br.com.book.room.quarto.presentation.quarto.cama.controller.swagger.QuartoCamaControllerSwagger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(QUARTO_CAMA_URI)
public class QuartoCamaController implements QuartoCamaControllerSwagger {

}
