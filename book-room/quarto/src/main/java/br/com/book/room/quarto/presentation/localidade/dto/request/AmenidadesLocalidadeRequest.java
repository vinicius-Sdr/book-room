package br.com.book.room.quarto.presentation.localidade.dto.request;

import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;
import br.com.book.room.quarto.presentation.localidade.dto.swagger.AmenidadesLocalidadeRequestSwagger;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import jakarta.validation.constraints.NotNull;

public record AmenidadesLocalidadeRequest(@NotNull(groups = {
		CreateInfo.class, UpdateInfo.class }) Long idAmenidade,
		@NotNull(groups = { CreateInfo.class, UpdateInfo.class }) Integer quantidade)
		implements
			AmenidadesLocalidadeRequestSwagger{

	public AmenidadesLocalidade toDomain() {

		return AmenidadesLocalidade.cadastro(idAmenidade, quantidade);
	}
}
