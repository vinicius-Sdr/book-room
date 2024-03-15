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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class QuartoCamaEntityId implements Serializable {

	private static final long serialVersionUID = -8432625081248223252L;

	@NotNull
	@Column(name = "id_quarto", nullable = false)
	private Long idQuarto;

	@NotNull
	@Column(name = "tipo_cama", nullable = false)
	private Long tipoCama;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		QuartoCamaEntityId entity = (QuartoCamaEntityId) o;
		return Objects.equals(this.tipoCama, entity.tipoCama) && Objects.equals(this.idQuarto, entity.idQuarto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoCama, idQuarto);
	}

}