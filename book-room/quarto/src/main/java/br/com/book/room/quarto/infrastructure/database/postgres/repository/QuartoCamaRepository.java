package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCama;
import br.com.book.room.quarto.domain.core.quarto.cama.QuartoCamaRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.QuartoCamaMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoCamaRepository extends JpaRepository<QuartoCamaEntity, Long>, QuartoCamaRepositoryPort {

    String QUARTO_CAMA_JA_CADASTRADO = "QuartoCama já cadastrado";
    String QUARTO_CAMA_NAO_ENCONTRADO = "QuartoCama não encontrado";

    default Page<QuartoCama> findAllQuartosCama(Pageable pageable) {
        Page<QuartoCamaEntity> entities = findAll(pageable);
        return entities.map(QuartoCamaMapper::toDomain);
    }

    default QuartoCama findQuartoCamaById(Long id) {
        QuartoCamaEntity entity = findById(id).orElseThrow(() -> new RuntimeException(QUARTO_CAMA_NAO_ENCONTRADO));
        return QuartoCamaMapper.toDomain(entity);
    }

    default QuartoCama saveQuartoCama(QuartoCama quartoCama) {
        QuartoCamaEntity savedEntity = null;
        try {
            QuartoCamaEntity entity = QuartoCamaMapper.toEntity(quartoCama);
            savedEntity = save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(QUARTO_CAMA_JA_CADASTRADO, e);
        }
        return QuartoCamaMapper.toDomain(savedEntity);
    }

    default void deleteQuartoCamaById(Long id) {
        try {
            deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("QuartoCama não pode ser excluído pois está vinculado a outras tabelas", e);
        }
    }

    default QuartoCama alterarQuartoCama(Long id, QuartoCama quartoCama) {
        QuartoCamaEntity entity = findById(id).orElseThrow(() -> new RuntimeException(QUARTO_CAMA_NAO_ENCONTRADO));
        try {
            entity = QuartoCamaMapper.updateEntityFromDomain(quartoCama, entity);
            QuartoCamaEntity savedEntity = save(entity);
            return QuartoCamaMapper.toDomain(savedEntity);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(QUARTO_CAMA_JA_CADASTRADO, e);
        }
    }
}