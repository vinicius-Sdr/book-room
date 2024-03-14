package br.com.book.room.quarto.config;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestClientAssuredBookRoom {

	public RequestSpecification getRequestSpecification() {
		int port = Integer.parseInt(System.getProperty("port"));

		return given().port(port)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.urlEncodingEnabled(false)
			.when()
			.log()
			.everything();
	}

}
