package dj.personal.website.project;

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

import dj.personal.website.Application;
import io.restassured.http.ContentType;

@SpringBootTest(classes = Application.class)
class ProjectControllerTest {
	private static final String API_GET_PROJECTS = "/api/projects";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUpRestAssured() {
		webAppContextSetup(webApplicationContext);
		enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	@WithMockUser(username = "admin", roles = { "website-admin" })
	void givenRoleAdmin_findProjectsReturnsAllProjectsInJsonFormat() {
		given()
				.when()
				.get(API_GET_PROJECTS)
				.then()
				.assertThat().statusCode(HttpStatus.OK.value())
				.assertThat().contentType(ContentType.JSON)
				.assertThat().body("size()", is(0));
	}

	@Test
	void givenNoRole_FindProjectsReturnsUnauthorized() {
		given()
				.when()
				.get(API_GET_PROJECTS)
				.then()
				.assertThat().statusCode(HttpStatus.UNAUTHORIZED.value());
	}
}
