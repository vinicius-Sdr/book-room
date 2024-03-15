package br.com.book.room.quarto.domain.core.tipo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TipoRepositoryPort {

	Page<Tipo> findAllTipos(Pageable pageable);

	Tipo findTipoById(Long id);

	Tipo saveTipo(Tipo tipo);

	void deleteTipoById(Long id);

	Tipo alterarTipo(Long id, Tipo tipo);

}