package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "predio", schema = "book_room_quarto",
		indexes = { @Index(name = "predio_id_localidade_nome_key", columnList = "id_localidade, nome", unique = true) })
public class PredioEntity implements Serializable {

	private static final long serialVersionUID = -717537128904236628L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_localidade", nullable = false)
	private LocalidadeEntity localidade;

	@Size(max = 255)
	@NotNull
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "data_inclusao")
	private Instant dataInclusao;

	@Column(name = "data_alteracao")
	private Instant dataAlteracao;

}