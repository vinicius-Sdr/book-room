package br.com.book.room.quarto.presentation.quarto.item.controller.swagger;

import br.com.book.room.quarto.presentation.quarto.item.dto.request.QuartoItemRequest;
import br.com.book.room.quarto.presentation.quarto.item.dto.response.QuartoItemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface QuartoItemControllerSwagger {

    ResponseEntity<QuartoItemResponse> cadastrar(
            QuartoItemRequest request,
            UriComponentsBuilder uriComponentsBuilder);
}
