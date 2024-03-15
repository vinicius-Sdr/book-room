package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

public record QuartoItemId(Long id, String tipoItem) implements Serializable {
}