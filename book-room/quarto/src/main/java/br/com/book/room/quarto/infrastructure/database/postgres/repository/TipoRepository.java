package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<TipoEntity, Long> {

}