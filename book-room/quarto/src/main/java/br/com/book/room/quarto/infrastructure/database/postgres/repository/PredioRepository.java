package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import java.util.Optional;

import br.com.book.room.quarto.applicaton.exception.BookRoomDataIntegrityViolationException;
import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.domain.core.predio.Predio;
import br.com.book.room.quarto.domain.core.predio.PredioRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.PredioEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.LocalidadeMapper;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.PredioMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredioRepository extends JpaRepository<PredioEntity, Long>, PredioRepositoryPort {

	String PREDIO_NAO_ENCONTRADO = "Predio não encontrado";

	String PREDIO_JA_CADASTRADO = "Predio já cadastrado";

	default Page<Predio> findAllPredios(Pageable pageable) {
		Page<PredioEntity> entities = findAll(pageable);
		return entities.map(PredioMapper::toDomain);
	}

	default Predio findPredioById(Long id) {
		Optional<PredioEntity> entity = findById(id);
		return entity.map(PredioMapper::toDomain)
			.orElseThrow(() -> new BookRoomEntityNotFoundException(PREDIO_NAO_ENCONTRADO));
	}

	default Predio savePredio(Predio predio) {
		PredioEntity savedEntity = null;
		try {
			PredioEntity entity = PredioMapper.toEntity(predio);
			savedEntity = save(entity);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(PREDIO_JA_CADASTRADO, e);
		}
		return PredioMapper.toDomain(savedEntity);
	}

	default void deletePredioById(Long id) {
		var predio = findPredioById(id);
		try {

			deleteById(predio.id());
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomDataIntegrityViolationException(
					"Predio não pode ser excluído pois está vinculado a outras tabelas", e);
		}
	}

	default Predio alterarPredio(Long id, Predio predio) {
		PredioEntity entity = null;
		PredioEntity savedEntity = null;
		try {
			entity = getReferenceById(id);
			if (!entity.getNome().equalsIgnoreCase(predio.nome())) {
				entity.setNome(predio.nome());
			}
			if (!entity.getLocalidade().getId().equals(predio.localidade().id())) {
				entity.setLocalidade(LocalidadeMapper.toEntity(predio.localidade()));
			}
			savedEntity = save(entity);
		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException(PREDIO_NAO_ENCONTRADO, e);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(PREDIO_JA_CADASTRADO, e);
		}
		return PredioMapper.toDomain(savedEntity);
	}

}