package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "quarto_camas", schema = "book_room_quarto")
public class QuartoCamaEntity implements Serializable {

	private static final long serialVersionUID = -7397330714487455939L;

	@EmbeddedId
	private QuartoCamaEntityId id;

	@MapsId("idQuarto")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_quarto", nullable = false)
	private QuartoEntity quarto;

	@NotNull
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@Column(name = "descricao", length = Integer.MAX_VALUE)
	private String descricao;

}