package dj.personal.website;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.webAppContextSetup;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.Method;

@SpringBootTest(classes = WebsiteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

	private static final String API_GET_BOOKS = "/api/book";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUpRestAssured() {
		webAppContextSetup(webApplicationContext);
		enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	@WithMockUser(username = "admin", roles = "website-admin")
	void findAllBooksReturnsAllBooksReadInProfessionalCareer() {
		given()
				.when()
				.request(Method.GET, API_GET_BOOKS)
				.then()
				.statusCode(HttpStatus.OK.value())
				.assertThat()
				.body("[0].title", is("lastReadBook"))
				.body("[1].title", is("secondLastReadBook"))
				.body("[2].title", is("thirdLastReadBook"));
	}

	@Test
	void unauthorizedWhenNotHavingWebsiteAdminRole() {
		given()
				.when()
				.request(Method.GET, API_GET_BOOKS)
				.then()
				.statusCode(HttpStatus.UNAUTHORIZED.value());
	}
}
