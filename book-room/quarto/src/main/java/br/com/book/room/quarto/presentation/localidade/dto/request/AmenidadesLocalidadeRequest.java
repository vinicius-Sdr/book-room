package br.com.book.room.quarto.presentation.localidade.dto.request;

import br.com.book.room.quarto.domain.core.amenidade.AmenidadesLocalidade;
import br.com.book.room.quarto.domain.core.amenidade.AmenidadesLocalidadeId;
import br.com.book.room.quarto.domain.core.amenidade.Amenidade;
import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.presentation.localidade.dto.swagger.AmenidadesLocalidadeRequestSwagger;
import br.com.book.room.quarto.presentation.validation.CreateInfo;
import br.com.book.room.quarto.presentation.validation.UpdateInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;

public record AmenidadesLocalidadeRequest(@NotNull(groups = {
		CreateInfo.class, UpdateInfo.class }) Long idLocalidade,
		@NotNull(groups = { CreateInfo.class, UpdateInfo.class }) Long idAmenidade,
		@NotNull(groups = { CreateInfo.class, UpdateInfo.class }) Integer quantidade) implements AmenidadesLocalidadeRequestSwagger {

	@JsonIgnore
	public AmenidadesLocalidadeRequest.AmenidadesLocalidadeIdRequet getAmendidadeLocalidadeId() {
		return new AmenidadesLocalidadeIdRequet(idLocalidade, idAmenidade);
	}

	public AmenidadesLocalidade toDomain() {

		return new AmenidadesLocalidade(getAmendidadeLocalidadeId().toDomain(), new Localidade(idLocalidade),
				new Amenidade(idAmenidade), quantidade);
	}
	public record AmenidadesLocalidadeIdRequet(Long idLocalidade, Long idAmenidade) {

		public AmenidadesLocalidadeId toDomain() {

			return new AmenidadesLocalidadeId(idLocalidade, idAmenidade);
		}
	}
}
