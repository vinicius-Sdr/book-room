package br.com.book.room.quarto.applicaton.localidade.service;

import java.util.HashSet;
import java.util.Set;

import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;
import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidadeRepositoryPort;
import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.domain.core.localidade.LocalidadeRepositoryPort;
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

		var amenidadesExistente = existingLocalidade.amenidades();

		// Criar um conjunto de amenidades para remover
		Set<AmenidadesLocalidade> amenidadesParaRemover = new HashSet<>(amenidadesExistente);
		amenidadesParaRemover.removeAll(amenidadesLocalidade);

		// Remover amenidades que não estão na nova lista
		for (AmenidadesLocalidade amenidade : amenidadesParaRemover) {
			amenidadesLocalidadeRepository.deleteAmenidadesLocalidadeById(amenidade.id().idLocalidade(),
					amenidade.id().idAmenidade());
		}

		// Criar um conjunto de amenidades para adicionar
		Set<AmenidadesLocalidade> amenidadesParaAdicionar = new HashSet<>(amenidadesLocalidade);
		amenidadesParaAdicionar.removeAll(amenidadesExistente);

		// Adicionar novas amenidades
		for (AmenidadesLocalidade amenidade : amenidadesParaAdicionar) {
			amenidadesLocalidadeRepository.saveAmenidadesLocalidade(amenidade.inserirIdLocalide(idLocalidade));
		}

		// Salvar a localidade atualizada no banco de dados

        return localidadeRepository.saveLocalidade(existingLocalidade);
	}

}