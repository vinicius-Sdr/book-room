package br.com.book.room.quarto.infrastructure.config.spring.api;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

public final class ApiRoutes {

	// URI base da API
	public static final String API = "/api";

	// Versão da API
	public static final String VERSAO = "/v1";

	// URI para as amenidades
	public static final String AMENIDADE_URI = API + VERSAO + "/amenidades";

	private ApiRoutes() {
	}

	public static URI construirUriAmenidadePorId(Long id) {
		return construirUriPorId(AMENIDADE_URI, id);
	}

	private static URI construirUriPorId(String recurso, Long id) {
		return UriComponentsBuilder.fromPath(API + VERSAO + "/" + recurso).path("/{id}").buildAndExpand(id).toUri();
	}

}
