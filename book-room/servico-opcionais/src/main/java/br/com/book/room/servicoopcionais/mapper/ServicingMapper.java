package br.com.book.room.servicoopcionais.mapper;

import br.com.book.room.servicoopcionais.model.DTO.ServicingDTO;
import br.com.book.room.servicoopcionais.model.Servicing;

import org.springframework.stereotype.Component;

@Component
public final class ServicingMapper {

	private ServicingMapper() {
	}

	public static Servicing convertToService(ServicingDTO servicingDTO) {

		return new Servicing(servicingDTO.getServiceName(), servicingDTO.getDescription(), servicingDTO.getPrice());
	}

}
