package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.PredioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredioRepository extends JpaRepository<PredioEntity, Long> {

}