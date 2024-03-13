package br.com.book.room.quarto.applicaton.amenidade.service.impl;

import java.util.List;
import java.util.Optional;

import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeService;
import br.com.book.room.quarto.applicaton.amenidade.service.dto.AmenidadeDto;
import br.com.book.room.quarto.applicaton.exception.EntityNotFoundException;
import br.com.book.room.quarto.applicaton.validacao.Validador;
import br.com.book.room.quarto.infrastructure.database.postgres.repository.AmenidadeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @see AmenidadeService
 */
public class AmenidadeServiceImpl implements AmenidadeService {

	private final AmenidadeRepository amenidadeRepository;

	private final List<Validador<AmenidadeDto>> validadores;

	public AmenidadeServiceImpl(AmenidadeRepository amenidadeRepository, List<Validador<AmenidadeDto>> validadores) {
		this.amenidadeRepository = amenidadeRepository;
		this.validadores = validadores;
	}

	@Override
	public Page<AmenidadeDto> consultarAmenidades(Pageable pageable) {

		return amenidadeRepository.findAll(pageable).map(AmenidadeDto::fromEntity);
	}

	@Override
	public AmenidadeDto consultarAmenidadePorId(Long id) {

		return amenidadeRepository.findById(id)
			.map(AmenidadeDto::fromEntity)
			.orElseThrow(() -> new EntityNotFoundException("Amenidade não encontrada"));
	}

	@Override
	public AmenidadeDto cadastrarAmenidade(AmenidadeDto amenidadeDto) {
		validadores.forEach(validador -> validador.validar(amenidadeDto));

		var amSalva = amenidadeRepository.save(amenidadeDto.toEntity());

		return new AmenidadeDto(amSalva.getId(), amSalva.getDescricao());
	}

	@Override
	public void deletarAmenidade(Long id) {
		amenidadeRepository.deleteById(id);
	}

	@Override
	public AmenidadeDto alterarAmenidade(AmenidadeDto amenidadeDto) {
		validadores.forEach(validador -> validador.validar(amenidadeDto));
		var amenidade = Optional.of(amenidadeRepository.getReferenceById(amenidadeDto.id()))
			.orElseThrow(() -> new EntityNotFoundException("Amenidade não encontrada"));

		amenidade.altualizarDadosAmidade(amenidadeDto.descricao());

		return AmenidadeDto.fromEntity(amenidadeRepository.save(amenidade));
	}

}
