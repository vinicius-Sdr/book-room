package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoItenRepository extends JpaRepository<QuartoItemEntity, QuartoItemIdEntity> {

}