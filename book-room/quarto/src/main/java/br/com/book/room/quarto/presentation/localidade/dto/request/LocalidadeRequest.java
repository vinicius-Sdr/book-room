package br.com.book.room.quarto.presentation.localidade.dto.request;

import java.util.Set;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.presentation.localidade.dto.swagger.LocalidadeRequestSwagger;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LocalidadeRequest(@NotEmpty(groups = {
		CreateInfo.class, UpdateInfo.class }) @Size(max = 255,
				groups = { CreateInfo.class, UpdateInfo.class }) String nome,
		@NotEmpty @Size(max = 255, groups = { CreateInfo.class, UpdateInfo.class }) String ruaAv,
		@Size(max = 5, groups = { CreateInfo.class, UpdateInfo.class }) String numero,
		@NotEmpty @Size(max = 9, groups = { CreateInfo.class, UpdateInfo.class }) String cep,
		@NotEmpty(groups = { CreateInfo.class, UpdateInfo.class }) @Size(max = 100,
				groups = { CreateInfo.class, UpdateInfo.class }) String cidade,
		@NotEmpty(groups = { CreateInfo.class, UpdateInfo.class }) @Size(max = 100,
				groups = { CreateInfo.class, UpdateInfo.class }) String estado,
		@NotEmpty(groups = { CreateInfo.class, UpdateInfo.class }) Set<@NotNull(
				groups = { CreateInfo.class, UpdateInfo.class }) AmenidadesLocalidadeRequest> amenidades)
		implements
			LocalidadeRequestSwagger{

	public Localidade toDomain() {
		return new Localidade(null, nome, ruaAv, numero, cep, cidade, estado);
	}
}
