package br.com.book.room.quarto.presentation.tipo.dto.request;

import br.com.book.room.quarto.domain.core.tipo.Tipo;
import br.com.book.room.quarto.presentation.tipo.dto.swagger.TipoRequestSwagger;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record TipoRequest(@NotEmpty(groups = {
		CreateInfo.class, UpdateInfo.class }) @Size(max = 255,
				groups = { CreateInfo.class, UpdateInfo.class }) String nome,
		@NotEmpty(groups = { CreateInfo.class, UpdateInfo.class }) @Size(max = 255,
				groups = { CreateInfo.class, UpdateInfo.class }) String categoria)
		implements
			TipoRequestSwagger{

	public Tipo toDomain() {
		return new Tipo(null, nome, categoria);
	}
}