package br.com.book.room.quarto.applicaton.tipo.service;

import br.com.book.room.quarto.domain.core.tipo.Tipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TipoService {

	Page<Tipo> consultarTipos(Pageable pageable);

	Tipo consultarTipoPorId(Long id);

	Tipo cadastrarTipo(Tipo tipo);

	void deletarTipo(Long id);

	Tipo alterarTipo(Long id, Tipo tipo);

}
