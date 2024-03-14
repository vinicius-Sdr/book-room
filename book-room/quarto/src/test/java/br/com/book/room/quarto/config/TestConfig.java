package br.com.book.room.quarto.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@EnableAutoConfiguration
@ActiveProfiles("test")
public class TestConfig {

	@Bean
	public RestClientAssuredBookRoom restClientAssuredBookRoom() {
		return new RestClientAssuredBookRoom();
	}

}
