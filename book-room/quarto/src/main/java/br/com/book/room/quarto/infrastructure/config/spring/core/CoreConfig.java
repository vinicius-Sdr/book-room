package br.com.book.room.quarto.infrastructure.config.spring.core;

import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeService;
import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeServiceImpl;
import br.com.book.room.quarto.applicaton.localidade.service.LocalidadeService;
import br.com.book.room.quarto.applicaton.localidade.service.LocalidadeServiceImpl;
import br.com.book.room.quarto.applicaton.predio.service.PredioService;
import br.com.book.room.quarto.applicaton.predio.service.PredioServiceImpl;
import br.com.book.room.quarto.applicaton.tipo.service.TipoService;
import br.com.book.room.quarto.applicaton.tipo.service.TipoServiceImpl;
import br.com.book.room.quarto.domain.core.amenidade.AmenidadeRepositoryPort;
import br.com.book.room.quarto.domain.core.localidade.LocalidadeRepositoryPort;
import br.com.book.room.quarto.domain.core.predio.PredioRepositoryPort;
import br.com.book.room.quarto.domain.core.tipo.TipoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

	/**
	 * @param amenidadeRepository
	 * @return
	 */
	@Bean
	AmenidadeService amenidadeService(AmenidadeRepositoryPort amenidadeRepository) {
		return new AmenidadeServiceImpl(amenidadeRepository);
	}

	/**
	 * @param localidadeRepositoryPort
	 * @return
	 */
	@Bean
	LocalidadeService localidadeService(LocalidadeRepositoryPort localidadeRepositoryPort) {
		return new LocalidadeServiceImpl(localidadeRepositoryPort);
	}

	/**
	 * @param predioRepository
	 * @return
	 */
	@Bean
	PredioService predioService(PredioRepositoryPort predioRepository) {
		return new PredioServiceImpl(predioRepository);
	}

	/**
	 * @param tipoRepository
	 * @return
	 */
	@Bean
	TipoService tipoService(TipoRepositoryPort tipoRepository) {
		return new TipoServiceImpl(tipoRepository);
	}

}
