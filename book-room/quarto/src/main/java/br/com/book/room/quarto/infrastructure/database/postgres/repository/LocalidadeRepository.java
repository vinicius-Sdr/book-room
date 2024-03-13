package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {

}