package br.com.book.room.quarto.domain.core.amenidade;

import java.io.Serializable;

public record Amenidade(Long id, String descricao) implements Serializable {

	public Amenidade(String descricao) {
		this(null, descricao);
	}

	public Amenidade(Long idAmenidade) {
		this(idAmenidade, null);
	}

	/**
	 * Retorna uma nova instância de Amenidade com a descrição atualizada.
	 * @param novaDescricao a nova descrição
	 * @return uma nova instância de Amenidade com a descrição atualizada
	 */
	public Amenidade comNovaDescricao(String novaDescricao) {
		return new Amenidade(this.id, novaDescricao);
	}
}