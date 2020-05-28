package dj.personal.website.translation;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.webAppContextSetup;
import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;

@SpringBootTest
class TranslationControllerTest {
	private static final String API_GET_TRANSLATIONS = "/api/translations";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUpRestAssured() {
		webAppContextSetup(webApplicationContext);
		enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	@WithMockUser(username = "admin", roles = { "website-admin" })
	void givenRoleAdmin_findTranslationsReturnsAllTranslationsInJsonFormat() {
		given()
				.when()
				.get(API_GET_TRANSLATIONS)
				.then()
				.assertThat().statusCode(HttpStatus.OK.value())
				.assertThat().contentType(ContentType.JSON)
				.assertThat().body("translations.keySet()", containsInAnyOrder("en", "fr", "nl"));
	}

	@Test
	void givenNoRole_FindTranslationsReturnsUnauthorized() {
		given()
				.when()
				.get(API_GET_TRANSLATIONS)
				.then()
				.assertThat().statusCode(HttpStatus.UNAUTHORIZED.value());
	}
}
