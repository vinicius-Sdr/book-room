package br.com.book.room.quarto.presentation.amenidade.dto.request;

import br.com.book.room.quarto.domain.core.amenidade.Amenidade;
import br.com.book.room.quarto.presentation.amenidade.dto.swagger.AmenidadeRequestSwagger;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record AmenidadeRequest(@NotEmpty(groups = {
		CreateInfo.class, UpdateInfo.class }, message = "Descrição é obrigatória") @Size(max = 255,
				groups = { CreateInfo.class, UpdateInfo.class },
				message = "Descrição deve ter no máximo 255 caracteres") String descricao)
		implements
			AmenidadeRequestSwagger{

	/**
	 * @return
	 */
	public Amenidade fromAmenidadeDto() {
		return new Amenidade(this.descricao());
	}
}
