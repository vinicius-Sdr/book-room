package br.com.book.room.quarto.applicaton.localidade;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocalidadeService {

	Page<Localidade> consultarLocalidades(Pageable pageable);

	Localidade consultarLocalidadePorId(Long id);

	Localidade cadastrarLocalidade(Localidade localidade);

	void deletarLocalidade(Long id);

	Localidade alterarLocalidade(Long id, Localidade localidade);

}
