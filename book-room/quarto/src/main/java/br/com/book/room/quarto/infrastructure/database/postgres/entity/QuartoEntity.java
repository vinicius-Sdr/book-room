package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "quarto", schema = "book_room_quarto",
		indexes = { @Index(name = "quarto_id_predio_tipo_key",
				columnList = "id_predio, tipo,id_localidade, identicacao", unique = true) })
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = { "id" })
public class QuartoEntity implements Serializable {

	private static final long serialVersionUID = -2853837012401991599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "identicacao", nullable = false)
	private String identicacao;

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_predio", nullable = false)
	private PredioEntity predio;

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_localidade", nullable = false)
	private LocalidadeEntity localidade;

	@NotNull
	@Column(name = "total_pessoas", nullable = false)
	private Integer totalPessoas;

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoEntity tipo;

	@NotNull
	@Column(name = "valor_diaria", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorDiaria;

	@NotNull
	@Column(name = "quantidade_quartos", nullable = false)
	private Integer quantidadeQuartos;

	@CreatedDate
	@Column(name = "data_inclusao")
	private LocalDateTime dataInclusao;

	@LastModifiedDate
	@Column(name = "data_alteracao")
	private LocalDateTime dataAlteracao;

}