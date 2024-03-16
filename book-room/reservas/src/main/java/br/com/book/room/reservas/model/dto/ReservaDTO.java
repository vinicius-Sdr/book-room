package br.com.book.room.reservas.model.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

	@NotNull(message = "O número de hospedes não pode ser nulo!")
	private int guests;

	@NotNull(message = "A data de Check-In não pode ser nula!")
	private LocalDateTime checkInDate;

	@NotNull(message = "A data de checkout não pode ser nula!")
	private LocalDateTime checkOutDate;

	@NotNull(message = "Id do cliente não pode ser nulo!")
	private Long clientId;

	@NotNull(message = "Id do quarto não pode ser nulo!")
	private Long roomId;

	@NotNull(message = "id do local não pode ser nulo!")
	private Long locale;

	@NotNull(message = "Id do prédio não pode ser nulo!")
	private Long building;

	@ElementCollection
	private List<Long> item;

	@ElementCollection
	private List<Long> servicing;

}
