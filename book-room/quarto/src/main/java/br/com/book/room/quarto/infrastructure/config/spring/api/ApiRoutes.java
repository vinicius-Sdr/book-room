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

	public static final String LOCALIDADE_URI = API + VERSAO + "/localidades";

	public static final String PREDIO_URI = API + VERSAO + "/predios";

	private ApiRoutes() {
	}

	public static URI construirUriAmenidadePorId(Long id) {
		return construirUriPorId(AMENIDADE_URI, id);
	}

	public static URI construirUriLocalidadePorId(Long id) {
		return construirUriPorId(LOCALIDADE_URI, id);
	}

	public static URI construirUriPredioPorId(Long id) {
		return construirUriPorId(PREDIO_URI, id);
	}

	private static URI construirUriPorId(String recurso, Long id) {
		return UriComponentsBuilder.fromPath(API + VERSAO + "/" + recurso).path("/{id}").buildAndExpand(id).toUri();
	}

}
