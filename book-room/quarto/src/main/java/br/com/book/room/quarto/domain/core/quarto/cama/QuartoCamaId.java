package br.com.book.room.quarto.domain.core.quarto.cama;

import java.io.Serializable;

public record QuartoCamaId(Long id, Long tipoCama) implements Serializable {
}