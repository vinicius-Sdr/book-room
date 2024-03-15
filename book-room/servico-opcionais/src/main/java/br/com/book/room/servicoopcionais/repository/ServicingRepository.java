package br.com.book.room.servicoopcionais.repository;

import br.com.book.room.servicoopcionais.model.Servicing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicingRepository extends JpaRepository<Servicing, Long> {

}
