package br.com.book.room.servicoopcionais.repository;

import br.com.book.room.servicoopcionais.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
