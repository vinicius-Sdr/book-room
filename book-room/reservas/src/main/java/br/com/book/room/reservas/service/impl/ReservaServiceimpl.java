package br.com.book.room.reservas.service.impl;

import br.com.book.room.reservas.model.Reserva;
import br.com.book.room.reservas.model.dto.ReservaDTO;
import br.com.book.room.reservas.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceimpl implements ReservaService {
    @Override
    public Reserva createReserva(ReservaDTO reservaDTO) {
        return null;
    }

    @Override
    public List<Reserva> getAllReservas() {
        return null;
    }

    @Override
    public Reserva findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity deleteReserva(Long id) {
        return null;
    }

    @Override
    public Reserva editReserva(Long id, ReservaDTO clientDTO) throws Exception {
        return null;
    }
}
