package br.com.book.room.quarto.domain.core.quarto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuartoRepositoryPort {

	Quarto cadastrarQuarto(Quarto quarto);

	Page<Quarto> findAllQuartos(Pageable pageable);

	Quarto findQuartoById(Long id);

	Quarto saveQuarto(Quarto quarto);

	void deleteQuartoById(Long id);

	Quarto alterarQuarto(Long id, Quarto quarto);

}
