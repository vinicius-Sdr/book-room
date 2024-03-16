package br.com.book.room.quarto.domain.core.quarto.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuartoItemRepositoryPort {

    QuartoItem cadastrarQuartoItem(QuartoItem quartoItem);

    Page<QuartoItem> findAllQuartoItems(Pageable pageable);

    QuartoItem findQuartoItemById(Long id);

    QuartoItem saveQuartoItem(QuartoItem quartoItem);

    void deleteQuartoItemById(Long id);

    QuartoItem alterarQuartoItem(Long id, QuartoItem quartoItem);
}