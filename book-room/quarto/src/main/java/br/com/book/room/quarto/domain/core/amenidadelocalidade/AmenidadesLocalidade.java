package br.com.book.room.quarto.domain.core.amenidadelocalidade;

import java.io.Serializable;

public record AmenidadesLocalidade(AmenidadesLocalidadeId id, Integer quantidade,
		String descricao) implements Serializable {

	public AmenidadesLocalidade(Long idAmenidade, Integer quantidade) {
		this(new AmenidadesLocalidadeId(null, idAmenidade), quantidade, null);
	}

	public AmenidadesLocalidade(AmenidadesLocalidadeId amenidadesLocalidadeId, Integer quantidade) {
		this(amenidadesLocalidadeId, quantidade, null);
	}

	public static AmenidadesLocalidade cadastro(Long idAmenidade, Integer quantidade) {

		return new AmenidadesLocalidade(idAmenidade, quantidade);
	}

	public AmenidadesLocalidade inserirIdLocalide(Long idLocalidade) {
		var amenidadesLocalidadeId = new AmenidadesLocalidadeId(idLocalidade, id.idAmenidade());
		return new AmenidadesLocalidade(amenidadesLocalidadeId, quantidade);
	}

	public AmenidadesLocalidade atualizarAmenidadeLocalidade(AmenidadesLocalidade amenidadeLocalidade) {
		return new AmenidadesLocalidade(this.id, // mantenha o id existente
				amenidadeLocalidade.quantidade(), this.descricao // mantenha a descrição
																	// existente
		);
	}
}