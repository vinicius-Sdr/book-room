package br.com.book.room.reservas.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ReservaDTO {

    private int guests;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private Long clientId;

    //private Room roomId;

    private List<Long> item;

    private List<Long> servicing;


}
