package br.com.book.room.clientes.model.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {

	@NotBlank(message = "Nome é um campo obrigatório e não pode estar em branco")
	private String name;

	@NotBlank(message = "Aniversario é um campo obrigatório e não pode estar em branco")
	private String birthDate;

	@NotBlank(message = "Aniversario é um campo obrigatório e não pode estar em branco")
	private String country;

	// @NotBlank(message = "Aniversario é um campo obrigatório e não pode estar em
	// branco")
	// (obrigatório de Brasileiro)
	private String CPF;

	// @NotBlank(message = "Aniversario é um campo obrigatório e não pode estar em
	// branco")
	// (obrigatório se estrangeiro)
	private String passport;

	@NotBlank(message = "Endereço é um campo obrigatório e não pode estar em branco")
	private String address;

	@NotBlank(message = "Telefone é um campo obrigatório e não pode estar em branco")
	private String cellphone;

	@NotBlank(message = "email é um campo obrigatório e não pode estar em branco")
	private String email;

}
