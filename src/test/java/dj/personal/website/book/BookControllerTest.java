package dj.personal.website.book;


import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class BookControllerTest {
	private static final String API_GET_BOOKS = "/api/books";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUpRestAssured() {
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}

	@Test
	@WithMockUser(username = "admin", roles = { "website-admin" })
	void givenRoleAdmin_findBooksReturnsAllBooksInJsonFormat() {
		given()
				.when()
				.auth().basic("admin", "EenEenvoudigWachtwoord")
				.get(API_GET_BOOKS)
				.then()
				.statusCode(HttpStatus.OK.value())
				.contentType(ContentType.JSON)
				.body("size()", is(27));
	}

	@Test
	void givenNoRole_FindBooksReturnsUnauthorized() {
		given()
				.when()
				.get(API_GET_BOOKS)
				.then()
				.statusCode(HttpStatus.UNAUTHORIZED.value());
	}
}
