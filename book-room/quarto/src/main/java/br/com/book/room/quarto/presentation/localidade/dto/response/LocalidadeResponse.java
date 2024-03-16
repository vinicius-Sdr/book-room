package br.com.book.room.quarto.presentation.localidade.dto.response;

import java.util.Set;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.presentation.localidade.dto.swagger.LocalidadeResponseSwagger;

public record LocalidadeResponse(Long id, String nome, String ruaAv, String numero, String cep, String cidade,
		String estado, Set<AmenidadesLocalidadeResponse> amenidades) implements LocalidadeResponseSwagger {

	public static LocalidadeResponse fromResponse(Localidade localidade) {

		var amenidadesLocalidadeResponses = AmenidadesLocalidadeResponse.fromResponse(localidade.amenidades());

		return new LocalidadeResponse(localidade.id(), localidade.nome(), localidade.ruaAv(), localidade.numero(),
				localidade.cep(), localidade.cidade(), localidade.estado(), amenidadesLocalidadeResponses);
	}

}