package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.time.Instant;

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
@Table(name = "amenidades_localidade", schema = "book_room_quarto")
public class AmenidadesLocalidade {

	@EmbeddedId
	private AmenidadesLocalidadeId id;

	@MapsId("idLocalidade")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_localidade", nullable = false)
	private Localidade idLocalidade;

	@MapsId("idAmenidade")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_amenidade", nullable = false)
	private Amenidade idAmenidade;

	@NotNull
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@Column(name = "data_inclusao")
	private Instant dataInclusao;

	@Column(name = "data_alteracao")
	private Instant dataAlteracao;

}