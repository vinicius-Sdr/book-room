package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "quarto_itens", schema = "book_room_quarto")
public class QuartoIten {

	@EmbeddedId
	private QuartoItenId id;

	@MapsId("idQuarto")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_quarto", nullable = false)
	private Quarto idQuarto;

	@NotNull
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

}