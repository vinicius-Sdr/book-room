package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "amenidades_localidade", schema = "book_room_quarto")
@EntityListeners(AuditingEntityListener.class)
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

	@CreatedDate
	@Column(name = "data_inclusao")
	private LocalDateTime dataInclusao;

	@LastModifiedDate
	@Column(name = "data_alteracao")
	private LocalDateTime dataAlteracao;

}