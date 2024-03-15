package br.com.book.room.quarto.applicaton.localidade.service;

import java.util.HashSet;
import java.util.Set;

import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;
import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidadeRepositoryPort;
import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.domain.core.localidade.LocalidadeRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeEntityId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class LocalidadeServiceImpl implements LocalidadeService {

	private final LocalidadeRepositoryPort localidadeRepository;

	private final AmenidadesLocalidadeRepositoryPort amenidadesLocalidadeRepository;

	public LocalidadeServiceImpl(LocalidadeRepositoryPort localidadeRepository,
			AmenidadesLocalidadeRepositoryPort amenidadesLocalidadeRepository) {
		this.localidadeRepository = localidadeRepository;
		this.amenidadesLocalidadeRepository = amenidadesLocalidadeRepository;
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
	public Localidade cadastrarLocalidade(Localidade localidade, Set<AmenidadesLocalidade> amenidadesLocalidade) {

		var savedLocalidade = localidadeRepository.saveLocalidade(localidade);
		var amenidadesLocalidadeInseridas = new HashSet<AmenidadesLocalidade>();

		amenidadesLocalidade.forEach(amenidadeLocalidade -> {
			var saveAmenidadesLocalidade = amenidadesLocalidadeRepository
				.saveAmenidadesLocalidade(amenidadeLocalidade.inserirIdLocalide(savedLocalidade.id()));
			amenidadesLocalidadeInseridas.add(saveAmenidadesLocalidade);
		});

		savedLocalidade.addAmenidades(amenidadesLocalidadeInseridas);
		return savedLocalidade;
	}

	@Override
	public void deletarLocalidade(Long id) {
		localidadeRepository.deleteLocalidadeById(id);
	}

	@Override
	public Localidade alterarLocalidade(Long idLocalidade, Localidade localidade,
			Set<AmenidadesLocalidade> amenidadesLocalidade) {

		// Buscar a localidade existente
		var existingLocalidade = localidadeRepository.findLocalidadeById(idLocalidade);

		// Atualizar os campos da localidade existente
		existingLocalidade.atualizarLocalidade(localidade);

		var amenidadesLocalidadeInseridas = new HashSet<AmenidadesLocalidade>();
		for (AmenidadesLocalidade amenidadeLocalidade : amenidadesLocalidade) {

			// adiciona o id da localidade
			amenidadeLocalidade.inserirIdLocalide(idLocalidade);

			var idAmenidadeLocalidade = new AmenidadesLocalidadeEntityId(existingLocalidade.id(),
					amenidadeLocalidade.id().idAmenidade());

			var existingAmenidadeLocalidade = amenidadesLocalidadeRepository
				.findAmenidadesLocalidadeById(idAmenidadeLocalidade);

			AmenidadesLocalidade amenidadeSalva = null;

			if (existingAmenidadeLocalidade != null) {
				amenidadeSalva = amenidadesLocalidadeRepository
					.atualizarQuantidadePorId(existingAmenidadeLocalidade.id(), amenidadeLocalidade.quantidade());
			}
			else {
				amenidadeSalva = amenidadesLocalidadeRepository.saveAmenidadesLocalidade(amenidadeLocalidade);
			}

			amenidadesLocalidadeInseridas.add(amenidadeSalva);
		}

		// Salvar a localidade atualizada no banco de dados
		var updatedLocalidade = localidadeRepository.saveLocalidade(existingLocalidade);
		updatedLocalidade.addAmenidades(amenidadesLocalidadeInseridas);

		return updatedLocalidade;
	}

}