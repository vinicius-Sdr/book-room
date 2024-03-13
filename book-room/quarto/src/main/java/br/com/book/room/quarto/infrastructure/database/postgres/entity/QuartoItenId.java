package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@Embeddable
public class QuartoItenId implements Serializable {

	private static final long serialVersionUID = -2786936631005598338L;

	@NotNull
	@Column(name = "id_quarto", nullable = false)
	private Integer idQuarto;

	@Size(max = 50)
	@NotNull
	@Column(name = "tipo_item", nullable = false, length = 50)
	private String tipoItem;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		QuartoItenId entity = (QuartoItenId) o;
		return Objects.equals(this.tipoItem, entity.tipoItem) && Objects.equals(this.idQuarto, entity.idQuarto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoItem, idQuarto);
	}

}