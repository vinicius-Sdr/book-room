package br.com.book.room.quarto.applicaton.tipo.service;

import br.com.book.room.quarto.domain.core.tipo.Tipo;
import br.com.book.room.quarto.domain.core.tipo.TipoRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TipoServiceImpl implements TipoService {

	private final TipoRepositoryPort tipoRepository;

	public TipoServiceImpl(TipoRepositoryPort tipoRepository) {
		this.tipoRepository = tipoRepository;
	}

	@Override
	public Page<Tipo> consultarTipos(Pageable pageable) {
		return tipoRepository.findAllTipos(pageable);
	}

	@Override
	public Tipo consultarTipoPorId(Long id) {
		return tipoRepository.findTipoById(id);
	}

	@Override
	public Tipo cadastrarTipo(Tipo tipo) {
		return tipoRepository.saveTipo(tipo);
	}

	@Override
	public void deletarTipo(Long id) {
		tipoRepository.deleteTipoById(id);
	}

	@Override
	public Tipo alterarTipo(Long id, Tipo tipo) {
		return tipoRepository.alterarTipo(id, tipo);
	}

}