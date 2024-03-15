package br.com.book.room.quarto.applicaton.predio.service;

import br.com.book.room.quarto.domain.core.predio.Predio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PredioService {

	Page<Predio> consultarPredios(Pageable pageable);

	Predio consultarPredioPorId(Long id);

	Predio cadastrarPredio(Predio predio);

	void deletarPredio(Long id);

	Predio alterarPredio(Long id, Predio predio);

}