package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoIten;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItenId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoItenRepository extends JpaRepository<QuartoIten, QuartoItenId> {

}