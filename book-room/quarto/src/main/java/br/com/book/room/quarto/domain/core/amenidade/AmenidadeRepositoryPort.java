package br.com.book.room.quarto.domain.core.amenidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AmenidadeRepositoryPort {

	Page<Amenidade> findAllAmenidades(Pageable pageable);

	Amenidade findAmenidadeById(Long id);

	Amenidade saveAmenidade(Amenidade amenidade);

	void deleteAmenidadeById(Long id);

	Amenidade alterarAmenidade(Long id, Amenidade amenidade);

}