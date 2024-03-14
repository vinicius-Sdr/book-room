package br.com.book.room.quarto.infrastructure.config.spring.core;

import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeService;
import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeServiceImpl;
import br.com.book.room.quarto.applicaton.localidade.LocalidadeService;
import br.com.book.room.quarto.applicaton.localidade.LocalidadeServiceImpl;
import br.com.book.room.quarto.domain.core.amenidade.AmenidadeRepositoryPort;
import br.com.book.room.quarto.domain.core.localidade.LocalidadeRepositoryPort;
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
		return new AmenidadeServiceImpl(amenidadeRepository) {
		};
	}

	/**
	 * @param localidadeRepositoryPort
	 * @return
	 */
	@Bean
	LocalidadeService localidadeService(LocalidadeRepositoryPort localidadeRepositoryPort) {
		return new LocalidadeServiceImpl(localidadeRepositoryPort);
	}

}
