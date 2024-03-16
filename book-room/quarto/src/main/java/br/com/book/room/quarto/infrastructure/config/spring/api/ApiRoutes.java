package br.com.book.room.quarto.infrastructure.config.spring.api;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

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

	public static final String TIPO_URI = API + VERSAO + "/tipos";

	public static final String QUARTO_CAMA_URI = API + VERSAO + "/quarto-camas";

	public static final String QUARTO_ITEM_URI = API + VERSAO + "/quarto-itens";

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

	public static URI construirUriTipoPorId(Long id) {
		return construirUriPorId(TIPO_URI, id);
	}

	public static URI construirUriQuartoCamaPorId(Map<String, Long> uriVariables) {

		return construirUriPorId(TIPO_URI, uriVariables);
	}

	public static URI construirUriQuartoItensPorId(Long id) {

		return construirUriPorId(QUARTO_ITEM_URI, id);
	}

	private static URI construirUriPorId(String recurso, Long id) {
		return UriComponentsBuilder.fromPath(API + VERSAO + "/" + recurso).path("/{id}").buildAndExpand(id).toUri();
	}

	private static URI construirUriPorId(String recurso, Map<String, Long> uriVariables) {
		String path = uriVariables.keySet().stream().map(key -> "/{" + key + "}").collect(Collectors.joining());

		return UriComponentsBuilder.fromPath(API + VERSAO + "/" + recurso)
			.path(path)
			.buildAndExpand(uriVariables)
			.toUri();
	}

}
