package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

public record QuartoItenId(Integer id, String tipoItem) implements Serializable {
}