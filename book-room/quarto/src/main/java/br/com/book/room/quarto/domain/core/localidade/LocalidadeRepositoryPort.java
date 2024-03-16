package br.com.book.room.quarto.domain.core.localidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocalidadeRepositoryPort {

	Page<Localidade> findAllLocalidades(Pageable pageable);

	Localidade findLocalidadeById(Long id);

	Localidade saveLocalidade(Localidade localidade);

	void deleteLocalidadeById(Long id);

	Localidade alterarLocalidade(Long id, Localidade localidade);

}
