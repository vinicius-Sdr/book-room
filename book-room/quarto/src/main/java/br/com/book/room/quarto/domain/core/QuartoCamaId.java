package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

public record QuartoCamaId(Integer id, Integer tipoCama) implements Serializable {
}