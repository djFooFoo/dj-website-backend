package dj.personal.website.certificate;


import static io.restassured.RestAssured.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.webAppContextSetup;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;

@SpringBootTest
class CertificateControllerTest {
	private static final String API_GET_CERTIFICATES = "/api/certificates";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUpRestAssured() {
		webAppContextSetup(webApplicationContext);
	}

	@Test
	@WithMockUser(username = "admin", roles = { "website-admin" })
	void givenRoleAdmin_findCertificatesReturnsAllCertificatesInJsonFormat() {
		given()
				.when()
				.auth().basic("admin", "EenEenvoudigWachtwoord")
				.get(API_GET_CERTIFICATES)
				.then()
				.statusCode(HttpStatus.OK.value())
				.contentType(ContentType.JSON)
				.body("size()", is(8));
	}

	@Test
	void givenNoRole_FindCertificatesReturnsUnauthorized() {
		given()
				.when()
				.get(API_GET_CERTIFICATES)
				.then()
				.statusCode(HttpStatus.UNAUTHORIZED.value());
	}
}
