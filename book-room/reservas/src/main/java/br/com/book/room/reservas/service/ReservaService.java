package br.com.book.room.reservas.service;

import br.com.book.room.reservas.model.Reserva;
import br.com.book.room.reservas.model.dto.ReservaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservaService {

	Reserva createReserva(ReservaDTO reservaDTO);

	List<Reserva> getAllReservas();

	Reserva findById(Long id);

	ResponseEntity deleteReserva(Long id);

	Reserva editReserva(Long id, ReservaDTO reservaDTO) throws Exception;

}
