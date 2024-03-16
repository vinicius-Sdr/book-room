package br.com.book.room.reservas.mapper;

import br.com.book.room.reservas.model.Reserva;
import br.com.book.room.reservas.model.dto.ReservaDTO;

public class ReservaMapper {

    public static Reserva convertToReserva(ReservaDTO reservaDTO){
        return new Reserva(
                reservaDTO.getGuests(),
                reservaDTO.getCheckInDate(),
                reservaDTO.getCheckOutDate(),
                reservaDTO.getClientId(),
                reservaDTO.getRoomId(),
                reservaDTO.getLocale(),
                reservaDTO.getBuilding(),
                reservaDTO.getItem(),
                reservaDTO.getServicing()
        );
    }

}
