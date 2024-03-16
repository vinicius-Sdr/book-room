package br.com.book.room.quarto.applicaton.quarto;


import br.com.book.room.quarto.domain.core.quarto.Quarto;
import br.com.book.room.quarto.domain.core.quarto.QuartoRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class QuartoServiceImpl implements QuartoService {

	private final QuartoRepositoryPort quartoRepository;

	@Override
	public Quarto cadastrarQuarto(Quarto quarto) {
		return quartoRepository.cadastrarQuarto(quarto);
	}

	public QuartoServiceImpl(QuartoRepositoryPort quartoRepository) {
		this.quartoRepository = quartoRepository;
	}

	@Override
	public Quarto alterarQuarto(Long id, Quarto quarto) {

		return quartoRepository.alterarQuarto(id, quarto);
	}

	@Override
	public void deletarQuarto(Long id) {
		quartoRepository.deleteQuartoById(id);
	}

	@Override
	public Quarto consultarQuartoPorId(Long id) {
		return quartoRepository.findQuartoById(id);
	}

	@Override
	public Page<Quarto> consultarQuartos(Pageable pageable) {
		return quartoRepository.findAllQuartos(pageable);
	}


}