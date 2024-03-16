package br.com.book.room.quarto.presentation.quarto.dto.request;

import java.math.BigDecimal;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.domain.core.predio.Predio;
import br.com.book.room.quarto.domain.core.quarto.Quarto;
import br.com.book.room.quarto.domain.core.tipo.Tipo;
import br.com.book.room.quarto.presentation.quarto.dto.swagger.QuartoRequestSwagger;

public record QuartoRequest(Long idPredio, Long idLocalidade, Long idTipo, Integer totalPessoas, BigDecimal valorDiaria,
		Integer quantidadeQuartos

) implements QuartoRequestSwagger {

	public Quarto fromQuartoDto() {

		return new Quarto(null, new Predio(idPredio), new Localidade(idLocalidade), totalPessoas, new Tipo(idTipo),
				valorDiaria, quantidadeQuartos);
	}
}
