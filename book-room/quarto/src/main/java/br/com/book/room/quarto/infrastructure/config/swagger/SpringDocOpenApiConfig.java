package br.com.book.room.quarto.infrastructure.config.swagger;

import br.com.book.room.quarto.infrastructure.config.swagger.properties.SwaggerConfigProperties;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

	private final SwaggerConfigProperties swaggerConfigProperties;

	public SpringDocOpenApiConfig(SwaggerConfigProperties swaggerConfigProperties) {
		this.swaggerConfigProperties = swaggerConfigProperties;
	}

	/**
	 * Configura e retorna a definição do OpenAPI.
	 */
	@Bean
	public OpenAPI openAPI() {
		var app = swaggerConfigProperties.getApplication();
		var info = new Info().title(app.title())
			.description(app.description())
			.version(app.version())
			.contact(new Contact().name("Fábio de Oliveira Sales")
				.email("fabio.oliveira.sales@gmail.com")
				.name("Vinicius Santana dos Reis")
				.email(""))
			.license(new License().name("MIT License"));
		return new OpenAPI().components(new Components()).info(info);
	}

}
