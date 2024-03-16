package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.domain.core.quarto.item.QuartoItem;
import br.com.book.room.quarto.domain.core.quarto.item.QuartoItemRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.QuartoItemMapper;
import org.springframework.dao.DataIntegrityViolationException;
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

}