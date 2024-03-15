package br.com.book.room.quarto.domain.core.quarto.item;

import java.io.Serializable;


public record QuartoItem(QuartoItemId id, Integer quantidade) implements Serializable {
}