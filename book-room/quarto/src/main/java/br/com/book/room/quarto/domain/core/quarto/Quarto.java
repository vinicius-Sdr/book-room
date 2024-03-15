package br.com.book.room.quarto.domain.core.quarto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.domain.core.predio.Predio;
import br.com.book.room.quarto.domain.core.tipo.Tipo;

public record Quarto(Long id, Predio predio, Localidade localidade, Integer totalPessoas, Tipo tipo,
		BigDecimal valorDiaria, Integer quantidadeQuartos
) implements Serializable {
}