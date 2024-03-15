package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.time.Instant;

import br.com.book.room.quarto.infrastructure.database.postgres.anotacao.FormatarString;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "amenidades", schema = "book_room_quarto",
		indexes = { @Index(name = "amenidades_descricao_key", columnList = "descricao", unique = true) })
@Builder(toBuilder = true)
public class AmenidadeEntity implements Serializable {

	private static final long serialVersionUID = 2918156029573710229L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Size(max = 255)
	@NotNull
	@Column(name = "descricao", nullable = false)
	@FormatarString
	private String descricao;

	@CreatedBy
	@Column(name = "data_inclusao")
	private Instant dataInclusao;

	@LastModifiedBy
	@Column(name = "data_alteracao")
	private Instant dataAlteracao;

	public AmenidadeEntity(Long id) {
		this.id = id;
	}

	public void altualizarDadosAmidade(@NotNull String descricao) {
		this.descricao = descricao;
	}

}