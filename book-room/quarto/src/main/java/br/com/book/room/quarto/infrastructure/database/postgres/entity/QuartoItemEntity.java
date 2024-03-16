package br.com.book.room.quarto.infrastructure.database.postgres.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "quarto_itens", schema = "book_room_quarto", indexes = { @Index(name = "quarto_id_item_tipo_item_key", columnList = "id_quarto, tipo_item", unique = true) })
@EntityListeners(AuditingEntityListener.class)
public class QuartoItemEntity implements Serializable {

	private static final long serialVersionUID = -6941946706320602490L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "id_quarto", nullable = false)
	private Long idQuarto;

	@Size(max = 50)
	@NotNull
	@Column(name = "tipo_item", nullable = false, length = 50)
	private String nomeItem;

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