package br.com.book.room.quarto.applicaton.localidade.service;

import java.util.Set;

import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;
import br.com.book.room.quarto.domain.core.localidade.Localidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocalidadeService {

	Page<Localidade> consultarLocalidades(Pageable pageable);

	Localidade consultarLocalidadePorId(Long id);

	Localidade cadastrarLocalidade(Localidade localidade, Set<AmenidadesLocalidade> amenidadesLocalidade);

	void deletarLocalidade(Long id);

	Localidade alterarLocalidade(Long idLocalidade, Localidade localidade,
			Set<AmenidadesLocalidade> amenidadesLocalidade);

}