package br.com.book.room.quarto.presentation.predio.dto.request;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.domain.core.predio.Predio;
import br.com.book.room.quarto.presentation.predio.dto.swagger.PredioRequestSwagger;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PredioRequest(@NotNull Long localidadeId,
		@NotEmpty @Size(max = 255) String nome) implements PredioRequestSwagger {
	public Predio toDomain() {
		Localidade localidade = new Localidade(localidadeId, null, null, null, null, null, null);
		return new Predio(null, localidade, nome);
	}
}