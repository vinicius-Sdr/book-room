package br.com.book.room.quarto.applicaton.quarto.item.service;

import br.com.book.room.quarto.domain.core.quarto.item.QuartoItem;
import br.com.book.room.quarto.domain.core.quarto.item.QuartoItemRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class QuartoItemServiceImpl implements QuartoItemService {

	private final QuartoItemRepositoryPort quartoItemRepository;

	@Override
	public QuartoItem cadastrarQuartoItem(QuartoItem quartoItem) {
		return quartoItemRepository.cadastrarQuartoItem(quartoItem);
	}

	public QuartoItemServiceImpl(QuartoItemRepositoryPort quartoItemRepository) {
		this.quartoItemRepository = quartoItemRepository;
	}

	@Override
	public QuartoItem alterarQuartoItem(Long id, QuartoItem quartoItem) {

		return quartoItemRepository.alterarQuartoItem(id, quartoItem);
	}

	@Override
	public void deletarQuartoItem(Long id) {
		quartoItemRepository.deleteQuartoItemById(id);
	}

	@Override
	public QuartoItem consultarQuartoItemPorId(Long id) {
		return quartoItemRepository.findQuartoItemById(id);
	}

	@Override
	public Page<QuartoItem> consultarQuartosCama(Pageable pageable) {
		return quartoItemRepository.findAllQuartoItems(pageable);
	}

}