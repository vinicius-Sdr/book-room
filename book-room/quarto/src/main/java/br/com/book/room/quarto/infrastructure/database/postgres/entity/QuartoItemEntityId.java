package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class QuartoItemEntityId implements Serializable {

	private static final long serialVersionUID = -4230876129961088019L;

	@NotNull
	@Column(name = "id_quarto", nullable = false)
	private Long idQuarto;

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
		QuartoItemEntityId entity = (QuartoItemEntityId) o;
		return Objects.equals(this.tipoItem, entity.tipoItem) && Objects.equals(this.idQuarto, entity.idQuarto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoItem, idQuarto);
	}

}