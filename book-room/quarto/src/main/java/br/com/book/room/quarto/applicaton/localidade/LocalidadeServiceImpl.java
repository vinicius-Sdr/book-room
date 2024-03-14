package br.com.book.room.quarto.applicaton.localidade;

import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.domain.core.localidade.LocalidadeRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class LocalidadeServiceImpl implements LocalidadeService {

	private final LocalidadeRepositoryPort localidadeRepository;

	public LocalidadeServiceImpl(LocalidadeRepositoryPort localidadeRepository) {
		this.localidadeRepository = localidadeRepository;
	}

	@Override
	public Page<Localidade> consultarLocalidades(Pageable pageable) {
		return localidadeRepository.findAllLocalidades(pageable);
	}

	@Override
	public Localidade consultarLocalidadePorId(Long id) {
		return localidadeRepository.findLocalidadeById(id);
	}

	@Override
	public Localidade cadastrarLocalidade(Localidade localidade) {
		return localidadeRepository.saveLocalidade(localidade);
	}

	@Override
	public void deletarLocalidade(Long id) {
		localidadeRepository.deleteLocalidadeById(id);
	}

	@Override
	public Localidade alterarLocalidade(Long id, Localidade localidade) {
		return localidadeRepository.alterarLocalidade(id, localidade);
	}

}