package br.com.book.room.quarto.applicaton.quarto.cama.service;

import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuartoCamaService {

	Page<QuartoCama> consultarQuartosCama(Pageable pageable);

	QuartoCama consultarQuartoCamaPorId(Long idQuarto, Long idTipoCama);

	QuartoCama cadastrarQuartoCama(QuartoCama quartoCama);

	void deletarQuartoCama(Long idQuarto, Long idTipoCama);

	QuartoCama alterarQuartoCama(Long idQuarto, Long idTipoCama, QuartoCama quartoCama);

}