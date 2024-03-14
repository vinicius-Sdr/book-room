package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "amenidades_localidade", schema = "book_room_quarto")
public class AmenidadesLocalidadeEntity implements Serializable {

	private static final long serialVersionUID = 2050456340189379097L;

	@EmbeddedId
	private AmenidadesLocalidadeEntityId id;

	@MapsId("idLocalidade")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_localidade", nullable = false)
	private LocalidadeEntity localidade;

	@MapsId("idAmenidade")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_amenidade", nullable = false)
	private AmenidadeEntity amenidade;

	@NotNull
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@CreatedBy
	@Column(name = "data_inclusao")
	private Instant dataInclusao;

	@LastModifiedBy
	@Column(name = "data_alteracao")
	private Instant dataAlteracao;

}