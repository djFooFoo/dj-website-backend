package dj.personal.website.book;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.webAppContextSetup;
import static org.hamcrest.Matchers.contains;

import java.util.Objects;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import dj.personal.website.WebsiteApplication;
import io.restassured.http.ContentType;

@SpringBootTest(classes = WebsiteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

	private static final String API_GET_BOOKS = "/api/books";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUpRestAssured() {
		webAppContextSetup(webApplicationContext);
		enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	@WithMockUser(username = "admin", roles = "website-admin")
	void whenSearchingForBooksWithRole_getAllBooksSortedByYearDesc() {
		BookMatcher[] expectedBooks = {
				BookMatcher.matchesBook(BookDto.builder().isbn(2L).title("book2").authors("author2").yearRead(2020).build()),
				BookMatcher.matchesBook(BookDto.builder().isbn(1L).title("book1").authors("author1").yearRead(2019).build()),
				BookMatcher.matchesBook(BookDto.builder().isbn(3L).title("book3").authors("author3").yearRead(2018).build())
		};

		given()
				.when()
				.get(API_GET_BOOKS)
				.then()
				.assertThat().statusCode(HttpStatus.OK.value())
				.assertThat().contentType(ContentType.JSON)
				.assertThat().body("$", contains(expectedBooks));
	}

	@Test
	void whenSearchingForBooksWithoutRole_returnsUnauthorized() {
		given()
				.when()
				.get(API_GET_BOOKS)
				.then()
				.assertThat().statusCode(HttpStatus.UNAUTHORIZED.value());
	}

	private static class BookMatcher extends BaseMatcher<BookDto> {
		private final BookDto expectedBook;

		private BookMatcher(BookDto expectedBook) {
			this.expectedBook = expectedBook;
		}

		public static BookMatcher matchesBook(BookDto expectedBook) {
			return new BookMatcher(expectedBook);
		}

		@Override
		public boolean matches(Object item) {
			BookDto actualBook = new ObjectMapper().convertValue(item, BookDto.class);

			return actualBook != null
					&& Objects.equals(actualBook.getIsbn(), expectedBook.getIsbn())
					&& Objects.equals(actualBook.getTitle(), expectedBook.getTitle())
					&& Objects.equals(actualBook.getAuthors(), expectedBook.getAuthors())
					&& Objects.equals(actualBook.getYearRead(), expectedBook.getYearRead());
		}

		@Override
		public void describeTo(Description description) {
			description
					.appendText("{"
							+ "\"isbn\": \"" + expectedBook.getIsbn() + "\","
							+ "\"title\": \"" + expectedBook.getTitle() + "\""
							+ "\"authors\": \"" + expectedBook.getAuthors() + "\""
							+ "\"yearRead\": \"" + expectedBook.getYearRead() + "\""
							+ "}");
		}
	}
}
