package br.com.book.room.quarto.infrastructure.database.postgres.entity;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "amenidades", schema = "book_room_quarto",
		indexes = { @Index(name = "amenidades_descricao_key", columnList = "descricao", unique = true) })
public class Amenidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 255)
	@NotNull
	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "data_inclusao")
	private Instant dataInclusao;

	@Column(name = "data_alteracao")
	private Instant dataAlteracao;

}