package br.com.book.room.quarto.applicaton.quarto.item.service;

import br.com.book.room.quarto.domain.core.quarto.item.QuartoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuartoItemService {

	QuartoItem cadastrarQuartoItem(QuartoItem quartoItem);

	QuartoItem alterarQuartoItem(Long id, QuartoItem quartoItem);

	void deletarQuartoItem(Long id);

	QuartoItem consultarQuartoItemPorId(Long id);

	Page<QuartoItem> consultarQuartosCama(Pageable pageable);

}
