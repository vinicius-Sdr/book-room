package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public record QuartoDto(Integer id, PredioDto predioDto, LocalidadeDto localidadeDto, Integer totalPessoas,
		TipoDto tipo, BigDecimal valorDiaria, Integer quantidadeQuartos) implements Serializable {
}