package br.com.book.room.servicoopcionais.mapper;

import br.com.book.room.servicoopcionais.model.DTO.ItemDTO;
import br.com.book.room.servicoopcionais.model.Item;
import org.springframework.stereotype.Component;

@Component
public final class ItemMapper {

	private ItemMapper() {
	}

	public static Item convertToItem(ItemDTO itemDTO) {

		return new Item(itemDTO.getItemName(), itemDTO.getDescription(), itemDTO.getPrice());
	}

}
