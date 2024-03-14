package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

public record QuartoItem(Long id, Quarto quarto, Integer quantidade) implements Serializable {
}