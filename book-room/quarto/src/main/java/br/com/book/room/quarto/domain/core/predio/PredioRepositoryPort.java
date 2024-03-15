package br.com.book.room.quarto.domain.core.predio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PredioRepositoryPort {

	Page<Predio> findAllPredios(Pageable pageable);

	Predio findPredioById(Long id);

	Predio savePredio(Predio predio);

	void deletePredioById(Long id);

	Predio alterarPredio(Long id, Predio predio);

}
