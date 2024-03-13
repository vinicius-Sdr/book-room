package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

public record AmenidadesLocalidadeDto(AmenidadesLocalidadeIdDto id, LocalidadeDto localidadeDto,
		AmenidadeDto amenidadeDto, Integer quantidade) implements Serializable {
}