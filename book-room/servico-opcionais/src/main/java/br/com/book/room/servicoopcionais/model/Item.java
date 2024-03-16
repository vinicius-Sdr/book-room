package br.com.book.room.servicoopcionais.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ITEM")
@Data
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "SERVICE_NAME")
	private String itemName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private double price;

	public Item(String itemName, String description, double price) {
		this.itemName = itemName;
		this.description = description;
		this.price = price;
	}

}
