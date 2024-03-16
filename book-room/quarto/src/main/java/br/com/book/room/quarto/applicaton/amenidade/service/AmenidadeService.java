package br.com.book.room.quarto.applicaton.amenidade.service;

import br.com.book.room.quarto.domain.core.amenidade.Amenidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AmenidadeService {

	/**
	 * @param pageable
	 * @return
	 */
	Page<Amenidade> consultarAmenidades(Pageable pageable);

	/**
	 * @param id
	 * @return
	 */
	Amenidade consultarAmenidadePorId(Long id);

	/**
	 * @param amenidade
	 * @return
	 */
	Amenidade cadastrarAmenidade(Amenidade amenidade);

	/**
	 * @param id
	 */
	void deletarAmenidade(Long id);

	/**
	 * @param id
	 * @param amenidade
	 * @return
	 */
	Amenidade alterarAmenidade(Long id, Amenidade amenidade);

}
