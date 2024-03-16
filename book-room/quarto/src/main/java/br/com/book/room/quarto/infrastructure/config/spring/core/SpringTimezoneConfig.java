package br.com.book.room.quarto.infrastructure.config.spring.core;

import java.util.TimeZone;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTimezoneConfig {

	@PostConstruct
	public void timezoneConfig() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

}
