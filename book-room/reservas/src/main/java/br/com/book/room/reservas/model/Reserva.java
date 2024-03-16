package br.com.book.room.reservas.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "RESERVA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int guests;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private Long clientId;

    private Long roomId;

    private Long locale;

    private Long building;

    @ElementCollection
    private List<Long> item;

    @ElementCollection
    private List<Long> servicing;



}
