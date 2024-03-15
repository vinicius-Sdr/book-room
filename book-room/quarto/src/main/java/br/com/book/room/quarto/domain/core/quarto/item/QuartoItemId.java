package br.com.book.room.quarto.domain.core.quarto.item;

import java.io.Serializable;

public record QuartoItemId(Long id, String tipoItem) implements Serializable {
}