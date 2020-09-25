package dj.personal.website.translation;

import dj.personal.website.Role;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class TranslationControllerTest {
	private static final String API_GET_TRANSLATIONS = "/api/translations/";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUpRestAssured() {
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}

	@Test
	@WithMockUser(username = "admin", roles = { Role.ADMIN })
	void givenRoleAdmin_findTranslationsReturnsAllTranslationsInJsonFormat() {
		given()
				.when()
				.auth().basic("admin", "EenEenvoudigWachtwoord")
				.get(API_GET_TRANSLATIONS)
				.then()
				.statusCode(HttpStatus.OK.value())
				.contentType(ContentType.JSON)
				.body("translations.keySet()", containsInAnyOrder("en", "fr", "nl"));
	}

	@Test
	void givenNoRole_FindTranslationsReturnsUnauthorized() {
		given()
				.when()
				.get(API_GET_TRANSLATIONS)
				.then()
				.statusCode(HttpStatus.UNAUTHORIZED.value());
	}
}
