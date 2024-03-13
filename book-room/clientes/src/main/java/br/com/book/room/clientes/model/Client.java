package br.com.book.room.clientes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String birthDate;

    private String country;

    //(obrigatório de Brasileiro)
    private String CPF;
    //(obrigatório se estrangeiro)
    private String passport;

    private String address;

    private String cellphone;

    private String email;

    public Client(String name, String birthDate, String country, String CPF, String passport, String address, String cellphone, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
        this.CPF = CPF;
        this.passport = passport;
        this.address = address;
        this.cellphone = cellphone;
        this.email = email;
    }
}

