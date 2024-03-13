package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoCamaRepository extends JpaRepository<QuartoCamaEntity, QuartoCamaEntityId> {

}