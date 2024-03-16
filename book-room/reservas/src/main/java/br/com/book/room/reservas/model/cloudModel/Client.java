package br.com.book.room.reservas.model.cloudModel;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

	private Long id;

	private String name;

	private String birthDate;

	private String country;

	private String cpf;

	private String passport;

	private String address;

	private String cellphone;

	private String email;

}
