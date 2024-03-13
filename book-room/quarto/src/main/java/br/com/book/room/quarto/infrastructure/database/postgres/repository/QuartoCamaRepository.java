package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCama;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoCamaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoCamaRepository extends JpaRepository<QuartoCama, QuartoCamaId> {

}