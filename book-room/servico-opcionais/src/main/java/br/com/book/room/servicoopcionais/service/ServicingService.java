package br.com.book.room.servicoopcionais.service;

import br.com.book.room.servicoopcionais.model.DTO.ServicingDTO;
import br.com.book.room.servicoopcionais.model.Servicing;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServicingService {

	Servicing createService(ServicingDTO clientDTO);

	List<Servicing> getAllServices();

	Servicing findById(Long id);

	ResponseEntity deleteService(Long id);

	Servicing editService(Long id, ServicingDTO clientDTO) throws Exception;

}
