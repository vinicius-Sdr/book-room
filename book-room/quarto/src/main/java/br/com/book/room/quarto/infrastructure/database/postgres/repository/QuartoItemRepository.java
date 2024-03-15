package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoItemRepository extends JpaRepository<QuartoItemEntity, QuartoItemEntityId> {

}