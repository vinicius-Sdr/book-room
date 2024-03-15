package br.com.book.room.quarto.domain.core.quarto.cama;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuartoCamaRepositoryPort {

	Page<QuartoCama> findAllQuartosCama(Pageable pageable);

	QuartoCama findQuartoCamaById(Long id);

	QuartoCama saveQuartoCama(QuartoCama quartoCama);

	void deleteQuartoCamaById(Long id);

	QuartoCama alterarQuartoCama(Long id, QuartoCama quartoCama);

}
