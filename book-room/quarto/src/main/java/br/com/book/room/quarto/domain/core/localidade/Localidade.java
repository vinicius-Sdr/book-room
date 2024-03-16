package br.com.book.room.quarto.domain.core.localidade;

import java.io.Serializable;
import java.util.Set;

import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;

public record Localidade(Long id, String nome, String ruaAv, String numero, String cep, String cidade, String estado,
		Set<AmenidadesLocalidade> amenidades) implements Serializable {

	public void addAmenidades(Set<AmenidadesLocalidade> amenidadesLocalidade) {
		amenidades.addAll(amenidadesLocalidade);
	}

	public Localidade(Long idLocalidade) {
		this(idLocalidade, null, null, null, null, null, null, null);
	}

	public Localidade atualizarLocalidade(Localidade localidade) {
		return new Localidade(this.id, // mantenha o id existente
				localidade.nome(), localidade.ruaAv(), localidade.numero(), localidade.cep(), localidade.cidade(),
				localidade.estado(), this.amenidades // mantenha as amenidades existentes
		);
	}
}