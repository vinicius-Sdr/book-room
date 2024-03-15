package br.com.book.room.quarto.infrastructure.config.swagger;

import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class GroupedOpenApiConfig {

	private static final String PATH_POSFIXO = "/**";

	@Bean
	public GroupedOpenApi amenidadeOpenApi() {
		String[] paths = { String.format("/%s%s", ApiRoutes.AMENIDADE_URI, PATH_POSFIXO) };
		return GroupedOpenApi.builder().group("Amenidade").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi localidadeOpenApi() {
		String[] paths = { String.format("/%s%s", ApiRoutes.LOCALIDADE_URI, PATH_POSFIXO) };
		return GroupedOpenApi.builder().group("Localidade").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi predioOpenApi() {
		String[] paths = { String.format("/%s%s", ApiRoutes.PREDIO_URI, PATH_POSFIXO) };
		return GroupedOpenApi.builder().group("Predio").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi tipoOpenApi() {
		String[] paths = { String.format("/%s%s", ApiRoutes.TIPO_URI, PATH_POSFIXO) };
		return GroupedOpenApi.builder().group("Tipo").pathsToMatch(paths).build();
	}

}
