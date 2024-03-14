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
@Table(name = "localidade", schema = "book_room_quarto",
		indexes = { @Index(name = "localidade_nome_key", columnList = "nome", unique = true) })
public class LocalidadeEntity implements Serializable {

	private static final long serialVersionUID = 8252873982797218714L;

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
	@Column(name = "rua_av", nullable = false)
	private String ruaAv;

	@Size(max = 5)
	@Column(name = "numero", length = 5)
	private String numero;

	@Size(max = 9)
	@NotNull
	@Column(name = "cep", nullable = false, length = 9)
	private String cep;

	@Size(max = 100)
	@NotNull
	@Column(name = "cidade", nullable = false, length = 100)
	private String cidade;

	@Size(max = 100)
	@NotNull
	@Column(name = "estado", nullable = false, length = 100)
	private String estado;

	@CreatedBy
	@Column(name = "data_inclusao")
	private Instant dataInclusao;

	@LastModifiedBy
	@Column(name = "data_alteracao")
	private Instant dataAlteracao;

}