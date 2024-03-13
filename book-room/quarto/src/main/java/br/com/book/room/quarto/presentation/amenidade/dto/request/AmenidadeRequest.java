package br.com.book.room.quarto.presentation.amenidade.dto.request;

import br.com.book.room.quarto.presentation.amenidade.dto.response.swagger.AmenidadeRequestSwagger;

public record AmenidadeRequest(String descricao) implements AmenidadeRequestSwagger {

}
