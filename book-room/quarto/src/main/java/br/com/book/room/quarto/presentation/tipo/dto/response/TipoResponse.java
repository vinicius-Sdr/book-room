package br.com.book.room.quarto.presentation.tipo.dto.response;

import br.com.book.room.quarto.domain.core.tipo.Tipo;
import br.com.book.room.quarto.presentation.tipo.dto.swagger.TipoResponseSwagger;

public record TipoResponse(Long id, String nome, String categoria) implements TipoResponseSwagger {
	public static TipoResponse fromDomain(Tipo tipo) {
		return new TipoResponse(tipo.id(), tipo.nome(), tipo.categoria());
	}
}