package br.com.book.room.quarto.applicaton.amenidade.service.impl;

import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeService;
import br.com.book.room.quarto.domain.core.amenidade.Amenidade;
import br.com.book.room.quarto.domain.core.amenidade.AmenidadeRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class AmenidadeServiceImpl implements AmenidadeService {

	private final AmenidadeRepositoryPort amenidadeRepository;

	public AmenidadeServiceImpl(AmenidadeRepositoryPort amenidadeRepository) {
		this.amenidadeRepository = amenidadeRepository;
	}

	@Override
	public Page<Amenidade> consultarAmenidades(Pageable pageable) {
		return amenidadeRepository.findAllAmenidades(pageable);
	}

	@Override
	public Amenidade consultarAmenidadePorId(Long id) {
		return amenidadeRepository.findAmenidadeById(id);
	}

	@Override
	public Amenidade cadastrarAmenidade(Amenidade amenidade) {

		return amenidadeRepository.saveAmenidade(amenidade);
	}

	@Override
	public void deletarAmenidade(Long id) {
		amenidadeRepository.deleteAmenidadeById(id);
	}

	@Override
	public Amenidade alterarAmenidade(Long id, Amenidade amenidade) {

		return amenidadeRepository.alterarAmenidade(id, amenidade);
	}

}