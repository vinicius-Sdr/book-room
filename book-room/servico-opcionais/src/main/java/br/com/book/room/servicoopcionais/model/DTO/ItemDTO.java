package br.com.book.room.servicoopcionais.model.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {

	@NotBlank(message = "O nome do item de consumo deve ser preenchido")
	private String itemName;

	private String description;

	@NotNull(message = "O preço unitário do item não pode ser vázio")
	private double price;

}
