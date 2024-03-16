package br.com.book.room.quarto.presentation.quarto.dto.response;

import java.math.BigDecimal;

import br.com.book.room.quarto.domain.core.quarto.Quarto;
import br.com.book.room.quarto.presentation.localidade.dto.response.LocalidadeResponse;
import br.com.book.room.quarto.presentation.predio.dto.response.PredioResponse;
import br.com.book.room.quarto.presentation.quarto.dto.swagger.QuartoResponseSwagger;
import br.com.book.room.quarto.presentation.tipo.dto.response.TipoResponse;

public record QuartoResponse(Long id, PredioResponse predio, LocalidadeResponse localidade,

		String identicacao,

		Integer totalPessoas,

		TipoResponse tipo,

		Integer quantidadeQuartos,

		BigDecimal valorDiaria

) implements QuartoResponseSwagger {

	public static QuartoResponse fromQuartoResponse(Quarto quarto) {

		return new QuartoResponse(quarto.id(), PredioResponse.fromDomain(quarto.predio()),
				LocalidadeResponse.fromResponse(quarto.localidade()), quarto.identicacao(), quarto.totalPessoas(),
				TipoResponse.fromDomain(quarto.tipo()), quarto.quantidadeQuartos(), quarto.valorDiaria());
	}
}
