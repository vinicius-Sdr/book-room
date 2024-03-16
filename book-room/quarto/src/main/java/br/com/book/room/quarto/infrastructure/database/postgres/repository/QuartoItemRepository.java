package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoItemRepository extends JpaRepository<QuartoItemEntity, Long> {

}