package br.com.book.room.quarto.presentation.localidade.dto.request;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.presentation.localidade.dto.swagger.LocalidadeRequestSwagger;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record LocalidadeRequest(@NotEmpty @Size(max = 255) String nome, @NotEmpty @Size(max = 255) String ruaAv,
		@Size(max = 5) String numero, @NotEmpty @Size(max = 9) String cep, @NotEmpty @Size(max = 100) String cidade,
		@NotEmpty @Size(max = 100) String estado) implements LocalidadeRequestSwagger {

	public Localidade toDomain() {
		return new Localidade(null, nome, ruaAv, numero, cep, cidade, estado);
	}
}
