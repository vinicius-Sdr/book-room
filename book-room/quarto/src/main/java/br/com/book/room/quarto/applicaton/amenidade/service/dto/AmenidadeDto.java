package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadeEntity;

public record AmenidadeDto(Long id, String descricao) implements Serializable {

	/**
	 * @param amenidadeEntity
	 * @return
	 */
	public static AmenidadeDto fromEntity(AmenidadeEntity amenidadeEntity) {
		return new AmenidadeDto(amenidadeEntity.getId(), amenidadeEntity.getDescricao());
	}

	/**
	 * @return
	 */
	public AmenidadeEntity toEntity() {

		return AmenidadeEntity.builder().id(this.id).descricao(this.descricao).build();
	}
}