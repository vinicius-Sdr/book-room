package br.com.book.room.quarto.domain.core.quarto.cama;

import java.io.Serializable;

import br.com.book.room.quarto.domain.core.tipo.Tipo;

public record QuartoCama(QuartoCamaId id, Tipo tipo, Integer quantidade,
                         String descricao) implements Serializable {
}