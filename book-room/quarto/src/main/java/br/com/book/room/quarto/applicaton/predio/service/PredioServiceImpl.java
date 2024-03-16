package br.com.book.room.quarto.applicaton.predio.service;

import br.com.book.room.quarto.domain.core.predio.Predio;
import br.com.book.room.quarto.domain.core.predio.PredioRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PredioServiceImpl implements PredioService {

	private final PredioRepositoryPort predioRepository;

	public PredioServiceImpl(PredioRepositoryPort predioRepository) {
		this.predioRepository = predioRepository;
	}

	@Override
	public Page<Predio> consultarPredios(Pageable pageable) {
		return predioRepository.findAllPredios(pageable);
	}

	@Override
	public Predio consultarPredioPorId(Long id) {
		return predioRepository.findPredioById(id);
	}

	@Override
	public Predio cadastrarPredio(Predio predio) {
		return predioRepository.savePredio(predio);
	}

	@Override
	public void deletarPredio(Long id) {
		predioRepository.deletePredioById(id);
	}

	@Override
	public Predio alterarPredio(Long id, Predio predio) {
		return predioRepository.alterarPredio(id, predio);
	}

}