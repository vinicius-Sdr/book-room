package br.com.book.room.quarto.presentation.predio.dto.response;

import br.com.book.room.quarto.domain.core.predio.Predio;
import br.com.book.room.quarto.presentation.predio.dto.swagger.PredioResponseSwagger;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PredioResponse(Long id, Long localidadeId, String nome) implements PredioResponseSwagger {
	public static PredioResponse fromDomain(Predio predio) {
		return new PredioResponse(predio.id(), predio.localidade() == null ? null : predio.localidade().id(),
				predio.nome());
	}
}