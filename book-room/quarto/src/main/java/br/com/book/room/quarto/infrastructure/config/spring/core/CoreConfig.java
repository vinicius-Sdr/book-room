package br.com.book.room.quarto.infrastructure.config.spring.core;

import br.com.book.room.quarto.applicaton.amenidade.service.AmenidadeService;
import br.com.book.room.quarto.applicaton.amenidade.service.impl.AmenidadeServiceImpl;
import br.com.book.room.quarto.infrastructure.database.postgres.repository.AmenidadeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

	/**
	 * @param amenidadeRepository
	 * @return
	 */
	@Bean
	AmenidadeService amenidadeService(AmenidadeRepository amenidadeRepository) {
		return new AmenidadeServiceImpl(amenidadeRepository) {
		};
	}

}
