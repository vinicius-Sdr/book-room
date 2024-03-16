package br.com.book.room.servicoopcionais.service.impl;

import br.com.book.room.servicoopcionais.mapper.ItemMapper;
import br.com.book.room.servicoopcionais.model.DTO.ItemDTO;
import br.com.book.room.servicoopcionais.model.Item;
import br.com.book.room.servicoopcionais.repository.ItemRepository;
import br.com.book.room.servicoopcionais.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(ItemDTO itemDTO) {

		Item item = ItemMapper.convertToItem(itemDTO);
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getAllItens() {
		return itemRepository.findAll();
	}

	@Override
	public Item findById(Long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public ResponseEntity deleteItem(Long id) {
		if (itemRepository.findById(id).isPresent()) {
			itemRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número de Id inválido");
	}

	@Override
	public Item editItem(Long id, ItemDTO itemDTO) throws Exception {
		Optional<Item> ItemOptional = itemRepository.findById(id);
		if (ItemOptional.isPresent()) {
			Item item = ItemMapper.convertToItem(itemDTO);
			item.setId(id);
			return itemRepository.save(item);
		}
		else {
			throw new Exception("Número de id inválido");
		}
	}

}
