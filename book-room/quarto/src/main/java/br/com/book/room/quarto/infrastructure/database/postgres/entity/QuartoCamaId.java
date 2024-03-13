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
public class QuartoCamaId implements Serializable {

	private static final long serialVersionUID = -7423807174463110466L;

	@NotNull
	@Column(name = "id_quarto", nullable = false)
	private Integer idQuarto;

	@NotNull
	@Column(name = "tipo_cama", nullable = false)
	private Integer tipoCama;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		QuartoCamaId entity = (QuartoCamaId) o;
		return Objects.equals(this.tipoCama, entity.tipoCama) && Objects.equals(this.idQuarto, entity.idQuarto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoCama, idQuarto);
	}

}