package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

import br.com.book.room.quarto.domain.core.amenidade.Amenidade;
import br.com.book.room.quarto.domain.core.localidade.Localidade;

public record AmenidadesLocalidade(AmenidadesLocalidadeId id, Localidade localidade, Amenidade amenidade,
		Integer quantidade) implements Serializable {
}