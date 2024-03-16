package br.com.book.room.quarto.applicaton.quarto.item.service;

import br.com.book.room.quarto.domain.core.quarto.item.QuartoItem;

public interface QuartoItemService {

	QuartoItem cadastrarQuartoItem(QuartoItem quartoItem);

	QuartoItem alterarQuartoItem(Long id, QuartoItem quartoItem);

	void deletarQuartoItem(Long id);

	QuartoItem consultarQuartoItemPorId(Long id);

}
