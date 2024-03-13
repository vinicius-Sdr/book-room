package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.Amenidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenidadeRepository extends JpaRepository<Amenidade, Integer> {

}