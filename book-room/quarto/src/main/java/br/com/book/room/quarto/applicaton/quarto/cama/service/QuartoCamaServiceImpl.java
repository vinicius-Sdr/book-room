package br.com.book.room.quarto.applicaton.quarto.cama.service;

import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCamaRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class QuartoCamaServiceImpl implements QuartoCamaService {

	private final QuartoCamaRepositoryPort quartoCamaRepository;

	public QuartoCamaServiceImpl(QuartoCamaRepositoryPort quartoCamaRepository) {
		this.quartoCamaRepository = quartoCamaRepository;
	}

	@Override
	public Page<QuartoCama> consultarQuartosCama(Pageable pageable) {
		return quartoCamaRepository.findAllQuartosCama(pageable);
	}

	@Override
	public QuartoCama consultarQuartoCamaPorId(Long idQuarto, Long idTipoCama) {
		return quartoCamaRepository.findQuartoCamaById(idQuarto, idTipoCama);
	}

	@Override
	public QuartoCama cadastrarQuartoCama(QuartoCama quartoCama) {
		return quartoCamaRepository.saveQuartoCama(quartoCama);
	}

	@Override
	public void deletarQuartoCama(Long idQuarto, Long idTipoCama) {
		quartoCamaRepository.deleteQuartoCamaById(idQuarto, idTipoCama);
	}

	@Override
	public QuartoCama alterarQuartoCama(Long idQuarto, Long idTipoCama, QuartoCama quartoCama) {
		return quartoCamaRepository.alterarQuartoCama(idQuarto, idTipoCama, quartoCama);
	}

}