package br.com.book.room.quarto.infrastructure.spring.config.validador;

import br.com.book.room.quarto.applicaton.amenidade.service.impl.AmenidadeCamposObrigatorioImpl;
import br.com.book.room.quarto.applicaton.validacao.Validador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidadorConfig {

	@Bean("validadorCamposObrigatorioAmenidade")
	Validador validadorCamposObrigatorioAmenidade() {

		return new AmenidadeCamposObrigatorioImpl();
	}

}
