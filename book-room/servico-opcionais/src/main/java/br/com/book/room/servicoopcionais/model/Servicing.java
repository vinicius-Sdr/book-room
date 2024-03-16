package br.com.book.room.servicoopcionais.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "SERVICE")
@Data
public class Servicing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "SERVICE_NAME")
	private String serviceName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private double price;

	public Servicing(String serviceName, String description, double price) {
		this.serviceName = serviceName;
		this.description = description;
		this.price = price;
	}

}
