package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

public record QuartoCamaDto(QuartoCamaIdDto id, QuartoDto quartoDto, TipoDto tipoDto, Integer quantidade,
		String descricao) implements Serializable {
}