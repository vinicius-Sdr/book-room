package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidade;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenidadesLocalidadeRepository extends JpaRepository<AmenidadesLocalidade, AmenidadesLocalidadeId> {

}