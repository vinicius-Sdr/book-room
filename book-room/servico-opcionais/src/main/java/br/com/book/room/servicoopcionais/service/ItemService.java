package br.com.book.room.servicoopcionais.service;


import br.com.book.room.servicoopcionais.model.DTO.ItemDTO;
import br.com.book.room.servicoopcionais.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ItemService {

    Item createItem(ItemDTO itemDTO);

    List<Item> getAllItens();

    Item findById(Long id);

    ResponseEntity deleteItem(Long id);

    Item editItem(Long id, ItemDTO clientDTO) throws Exception;

}
