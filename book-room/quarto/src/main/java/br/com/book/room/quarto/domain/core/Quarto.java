package br.com.book.room.quarto.domain.core;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.book.room.quarto.domain.core.localidade.Localidade;

public record Quarto(Integer id, Predio predio, Localidade localidade, Integer totalPessoas, Tipo tipo,
		BigDecimal valorDiaria, Integer quantidadeQuartos) implements Serializable {
}