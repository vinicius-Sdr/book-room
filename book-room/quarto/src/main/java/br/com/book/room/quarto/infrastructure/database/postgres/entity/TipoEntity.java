package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "tipo", schema = "book_room_quarto",
		indexes = { @Index(name = "tipo_nome_categoria_key", columnList = "nome, categoria", unique = true) })
public class TipoEntity implements Serializable {

	private static final long serialVersionUID = -4141237128897642674L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Size(max = 255)
	@NotNull
	@Column(name = "nome", nullable = false)
	private String nome;

	@Size(max = 255)
	@NotNull
	@Column(name = "categoria", nullable = false)
	private String categoria;

	@CreatedBy
	@Column(name = "data_inclusao")
	private Instant dataInclusao;

	@LastModifiedBy
	@Column(name = "data_alteracao")
	private Instant dataAlteracao;

}