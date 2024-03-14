package br.com.book.room.quarto.bdd;

import br.com.book.room.quarto.infrastructure.config.spring.api.ApiRoutes;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest
public class AmenidadesSteps {

	@LocalServerPort
	private int port;

	private Response response;

	private final static String BASE_URI = "http://localhost";

	@Before
	public void setup() throws Exception {

		RestAssured.baseURI = BASE_URI;
		RestAssured.port = port;

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Quando("faço uma requisição para listar todas as amenidades")
	public void faço_uma_requisição_para_listar_todas_as_amenidades() {
		response = RestAssured.get(ApiRoutes.AMENIDADE_URI);
		response.then().log().all();
	}

	@Então("deve ser retornado o status code {int}")
	public void deve_ser_retornado_o_status_code(Integer statusCode) {
	//	assertEquals(statusCode, response.getStatusCode());
	}

	@Então("deve ser retornado todas as amenidades cadastradas")
	public void deve_ser_retornado_todas_as_amenidades_cadastradas() {
	//	assertEquals(200, response.getStatusCode());
	}

}