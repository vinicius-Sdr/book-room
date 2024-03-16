package br.com.book.room.servicoopcionais.service.impl;

import br.com.book.room.servicoopcionais.mapper.ServicingMapper;
import br.com.book.room.servicoopcionais.model.DTO.ServicingDTO;
import br.com.book.room.servicoopcionais.model.Servicing;
import br.com.book.room.servicoopcionais.repository.ServicingRepository;
import br.com.book.room.servicoopcionais.service.ServicingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicingServiceImpl implements ServicingService {

	@Autowired
	private ServicingRepository servicingRepository;

	@Override
	public Servicing createService(ServicingDTO servicingDTO) {

		Servicing servicing = ServicingMapper.convertToService(servicingDTO);
		return servicingRepository.save(servicing);
	}

	@Override
	public List<Servicing> getAllServices() {
		return servicingRepository.findAll();
	}

	@Override
	public Servicing findById(Long id) {
		return servicingRepository.findById(id).get();
	}

	@Override
	public ResponseEntity deleteService(Long id) {
		if (servicingRepository.findById(id).isPresent()) {
			servicingRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número de Id inválido");
	}

	@Override
	public Servicing editService(Long id, ServicingDTO servicingDTO) throws Exception {
		Optional<Servicing> userOptional = servicingRepository.findById(id);
		if (userOptional.isPresent()) {
			Servicing servicing = ServicingMapper.convertToService(servicingDTO);
			servicing.setId(id);
			return servicingRepository.save(servicing);
		}
		else {
			throw new Exception("Número de id inválido");
		}
	}

}
