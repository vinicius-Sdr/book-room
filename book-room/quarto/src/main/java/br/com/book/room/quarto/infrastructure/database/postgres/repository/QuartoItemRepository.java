package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.applicaton.exception.BookRoomDataIntegrityViolationException;
import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.domain.core.quarto.item.QuartoItem;
import br.com.book.room.quarto.domain.core.quarto.item.QuartoItemRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.QuartoItemMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoItemRepository extends JpaRepository<QuartoItemEntity, Long>, QuartoItemRepositoryPort {

	default QuartoItem cadastrarQuartoItem(QuartoItem quartoItem) {
		QuartoItemEntity savedQuartoItem = null;

		try {
			savedQuartoItem = save(QuartoItemMapper.toEntity(quartoItem));
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException("Item já cadastrado");
		}

		return QuartoItemMapper.toDomain(savedQuartoItem);
	}

	default Page<QuartoItem> findAllQuartoItems(Pageable pageable) {
		Page<QuartoItemEntity> entities = findAll(pageable);
		return entities.map(QuartoItemMapper::toDomain);
	}

	default QuartoItem findQuartoItemById(Long id) {
		QuartoItemEntity entity = findById(id)
			.orElseThrow(() -> new BookRoomEntityNotFoundException("Item não encontrado"));
		return QuartoItemMapper.toDomain(entity);
	}

	default QuartoItem saveQuartoItem(QuartoItem quartoItem) {
		QuartoItemEntity savedEntity = null;
		try {
			QuartoItemEntity entity = QuartoItemMapper.toEntity(quartoItem);
			savedEntity = save(entity);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException("Item já cadastrado", e);
		}
		return QuartoItemMapper.toDomain(savedEntity);
	}

	default void deleteQuartoItemById(Long id) {
		try {
			findQuartoItemById(id);
			deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomDataIntegrityViolationException(
					"Item não pode ser excluído pois está vinculado a outras tabelas", e);
		}
	}

	default QuartoItem alterarQuartoItem(Long id, QuartoItem quartoItem) {
		QuartoItemEntity entity = findById(id)
			.orElseThrow(() -> new BookRoomEntityNotFoundException("Item não encontrado"));
		try {
			entity = save(QuartoItemMapper.updateEntityFromDomain(quartoItem, entity));

		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException("Item não encontrado", e);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException("Item já cadastrado", e);
		}
		return QuartoItemMapper.toDomain(entity);
	}

}