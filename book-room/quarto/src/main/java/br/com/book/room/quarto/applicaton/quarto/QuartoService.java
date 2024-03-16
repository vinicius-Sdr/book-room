package br.com.book.room.quarto.applicaton.quarto;


import br.com.book.room.quarto.domain.core.quarto.Quarto;

public interface QuartoService {

	Quarto cadastrarQuarto(Quarto quarto);

	Quarto alterarQuarto(Long id, Quarto quarto);

	void deletarQuarto(Long id);

	Quarto consultarQuartoPorId(Long id);

}
