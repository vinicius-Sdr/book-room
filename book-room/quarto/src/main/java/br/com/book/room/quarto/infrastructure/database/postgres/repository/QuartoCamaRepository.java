package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCamaRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaEntityId;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.QuartoCamaMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoCamaRepository
		extends JpaRepository<QuartoCamaEntity, QuartoCamaEntityId>, QuartoCamaRepositoryPort {

	String QUARTO_CAMA_JA_CADASTRADO = "QuartoCama já cadastrado";

	String QUARTO_CAMA_NAO_ENCONTRADO = "QuartoCama não encontrado";

	default Page<QuartoCama> findAllQuartosCama(Pageable pageable) {
		Page<QuartoCamaEntity> entities = findAll(pageable);
		return entities.map(QuartoCamaMapper::toDomain);
	}

	default QuartoCama findQuartoCamaById(Long idQuarto, Long idTipoCama) {
		var id = new QuartoCamaEntityId(idQuarto, idTipoCama);
		QuartoCamaEntity entity = findById(id)
			.orElseThrow(() -> new BookRoomEntityNotFoundException(QUARTO_CAMA_NAO_ENCONTRADO));
		return QuartoCamaMapper.toDomain(entity);
	}

	default QuartoCama saveQuartoCama(QuartoCama quartoCama) {
		QuartoCamaEntity savedEntity = null;
		try {
			QuartoCamaEntity entity = QuartoCamaMapper.toEntity(quartoCama);
			savedEntity = save(entity);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(QUARTO_CAMA_JA_CADASTRADO, e);
		}
		return QuartoCamaMapper.toDomain(savedEntity);
	}

	default void deleteQuartoCamaById(Long idQuarto, Long idTipoCama) {
		try {
			var id = new QuartoCamaEntityId(idQuarto, idTipoCama);
			deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(
					"QuartoCama não pode ser excluído pois está vinculado a outras tabelas", e);
		}
	}

	default QuartoCama alterarQuartoCama(Long idQuarto, Long idTipoCama, QuartoCama quartoCama) {
		var id = new QuartoCamaEntityId(idQuarto, idTipoCama);

		QuartoCamaEntity entity = findById(id)
			.orElseThrow(() -> new BookRoomEntityNotFoundException(QUARTO_CAMA_NAO_ENCONTRADO));
		try {
			entity = QuartoCamaMapper.updateEntityFromDomain(quartoCama, entity);
			QuartoCamaEntity savedEntity = save(entity);
			return QuartoCamaMapper.toDomain(savedEntity);
		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException(QUARTO_CAMA_NAO_ENCONTRADO, e);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(QUARTO_CAMA_JA_CADASTRADO, e);
		}
	}

}