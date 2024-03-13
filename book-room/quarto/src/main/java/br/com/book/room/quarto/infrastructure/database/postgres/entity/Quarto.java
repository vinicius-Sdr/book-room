package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.math.BigDecimal;
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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "quarto", schema = "book_room_quarto",
		indexes = { @Index(name = "quarto_id_predio_tipo_key", columnList = "id_predio, tipo", unique = true) })
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_predio", nullable = false)
	private Predio idPredio;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_localidade", nullable = false)
	private Localidade idLocalidade;

	@NotNull
	@Column(name = "total_pessoas", nullable = false)
	private Integer totalPessoas;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tipo", nullable = false)
	private Tipo tipo;

	@NotNull
	@Column(name = "valor_diaria", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorDiaria;

	@NotNull
	@Column(name = "quantidade_quartos", nullable = false)
	private Integer quantidadeQuartos;

	@Column(name = "data_inclusao")
	private Instant dataInclusao;

	@Column(name = "data_alteracao")
	private Instant dataAlteracao;

}