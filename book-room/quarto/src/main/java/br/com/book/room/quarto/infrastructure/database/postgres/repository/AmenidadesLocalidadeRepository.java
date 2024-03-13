package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenidadesLocalidadeRepository
		extends JpaRepository<AmenidadesLocalidadeEntity, AmenidadesLocalidadeEntityId> {

}