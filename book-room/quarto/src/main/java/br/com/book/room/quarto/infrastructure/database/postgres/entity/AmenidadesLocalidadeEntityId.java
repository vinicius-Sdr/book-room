package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class AmenidadesLocalidadeEntityId implements Serializable {

	private static final long serialVersionUID = 324196855271072808L;

	@NotNull
	@Column(name = "id_localidade", nullable = false)
	private Long idLocalidade;

	@NotNull
	@Column(name = "id_amenidade", nullable = false)
	private Long idAmenidade;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		AmenidadesLocalidadeEntityId entity = (AmenidadesLocalidadeEntityId) o;
		return Objects.equals(this.idLocalidade, entity.idLocalidade)
				&& Objects.equals(this.idAmenidade, entity.idAmenidade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLocalidade, idAmenidade);
	}

}