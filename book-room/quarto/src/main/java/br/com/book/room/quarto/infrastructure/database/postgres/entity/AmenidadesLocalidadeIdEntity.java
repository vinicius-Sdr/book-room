package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@Embeddable
public class AmenidadesLocalidadeIdEntity implements Serializable {

	private static final long serialVersionUID = 7203746101749645661L;

	@NotNull
	@Column(name = "id_localidade", nullable = false)
	private Integer idLocalidade;

	@NotNull
	@Column(name = "id_amenidade", nullable = false)
	private Integer idAmenidade;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		AmenidadesLocalidadeIdEntity entity = (AmenidadesLocalidadeIdEntity) o;
		return Objects.equals(this.idLocalidade, entity.idLocalidade)
				&& Objects.equals(this.idAmenidade, entity.idAmenidade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLocalidade, idAmenidade);
	}

}