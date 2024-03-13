package br.com.book.room.clientes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CLIENT")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLIENT_NAME")
    private String name;

    @Column(name ="BIRTH_DATE")
    private String birthDate;

    @Column(name ="COUNTRY")
    private String country;

    //(obrigatório de Brasileiro)
    @Column(name ="CPF")
    private String CPF;
    //(obrigatório se estrangeiro)
    @Column(name ="PASSPORT")
    private String passport;

    @Column(name ="ADDRESS")
    private String address;

    @Column(name ="CELLPHONE")
    private String cellphone;

    @Column(name ="EMAIL")
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

