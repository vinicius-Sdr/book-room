package br.com.book.room.quarto.presentation.localidade.dto.response;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.presentation.localidade.dto.swagger.LocalidadeResponseSwagger;

public record LocalidadeResponse(Long id, String nome, String ruaAv, String numero, String cep, String cidade,
		String estado) implements LocalidadeResponseSwagger {

	public static LocalidadeResponse fromResponse(Localidade localidade) {
		return new LocalidadeResponse(localidade.id(), localidade.nome(), localidade.ruaAv(), localidade.numero(),
				localidade.cep(), localidade.cidade(), localidade.estado());
	}
}