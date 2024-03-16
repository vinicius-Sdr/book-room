package br.com.book.room.reservas.service.impl;

import br.com.book.room.reservas.mapper.ReservaMapper;
import br.com.book.room.reservas.model.Email;
import br.com.book.room.reservas.model.Reserva;
import br.com.book.room.reservas.model.dto.ReservaDTO;
import br.com.book.room.reservas.repository.ReservaRepository;
import br.com.book.room.reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceimpl implements ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;

    private final EmailSeviceImpl emailService;

    public ReservaServiceimpl(EmailSeviceImpl emailService) {
        this.emailService = emailService;
    }


    @Override
    public Reserva createReserva(ReservaDTO reservaDTO) {
        Reserva item = ReservaMapper.convertToReserva(reservaDTO);
        item = reservaRepository.save(item);

        Email email = new Email("noreply@hotel.com", "Nova Reserva", "Foi efetuado uma nova reserva com sucesso, mais detalhes a seguir:" + item.toString());
        emailService.sendEmail(email);

        return item;
    }

    @Override
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva findById(Long id) {
        return reservaRepository.findById(id).get();
    }

    @Override
    public ResponseEntity deleteReserva(Long id) {
        if (reservaRepository.findById(id).isPresent()) {
            reservaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número de Id inválido");
    }

    @Override
    public Reserva editReserva(Long id, ReservaDTO reservaDTO) throws Exception {
        Optional<Reserva> ItemOptional = reservaRepository.findById(id);
        if (ItemOptional.isPresent()) {
            Reserva item = ReservaMapper.convertToReserva(reservaDTO);
            item.setId(id);
            return reservaRepository.save(item);
        } else {
            throw new Exception("Número de id inválido");
        }
    }
}
