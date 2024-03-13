package br.com.book.room.quarto.applicaton.amenidade.service;

import br.com.book.room.quarto.applicaton.amenidade.service.dto.AmenidadeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AmenidadeService {

	/**
	 * @param pageable
	 * @return
	 */
	Page<AmenidadeDto> consultarAmenidades(Pageable pageable);

	/**
	 * @param id
	 * @return
	 */
	AmenidadeDto consultarAmenidadePorId(Long id);

	/**
	 * @param amenidadeDto
	 * @return
	 */
	AmenidadeDto cadastrarAmenidade(AmenidadeDto amenidadeDto);

	/**
	 * @param id
	 */
	void deletarAmenidade(Long id);

	/**
	 * @param amenidadeDto
	 * @return
	 */
	AmenidadeDto alterarAmenidade(AmenidadeDto amenidadeDto);

}
