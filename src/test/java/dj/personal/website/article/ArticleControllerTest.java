package dj.personal.website.article;


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
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ArticleControllerTest {
	private static final String API_GET_ARTICLES = "/api/articles/";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUpRestAssured() {
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}

	@Test
	@WithMockUser(username = "admin", roles = { "website-admin" })
	void givenRoleAdmin_findArticlesReturnsAllArticlesInJsonFormat() {
		given()
				.when()
				.auth().basic("admin", "EenEenvoudigWachtwoord")
				.get(API_GET_ARTICLES)
				.then()
				.statusCode(HttpStatus.OK.value())
				.contentType(ContentType.JSON)
				.body("size()", is(31));
	}

	@Test
	void givenNoRole_FindArticlesReturnsUnauthorized() {
		given()
				.when()
				.get(API_GET_ARTICLES)
				.then()
				.statusCode(HttpStatus.UNAUTHORIZED.value());
	}
}
