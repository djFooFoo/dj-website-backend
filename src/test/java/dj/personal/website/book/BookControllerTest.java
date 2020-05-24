package dj.personal.website.book;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.webAppContextSetup;
import static org.hamcrest.Matchers.contains;

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

import io.restassured.http.ContentType;

@SpringBootTest
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
	@WithMockUser(username = "admin", roles = { "website-admin" })
	void givenRoleAdmin_findBooksReturnsBooksFromBookDataSqlFile() {
		given()
				.when()
				.get(API_GET_BOOKS)
				.then()
				.assertThat().statusCode(HttpStatus.OK.value())
				.assertThat().contentType(ContentType.JSON)
				.assertThat().body("$", contains(
				BookMatcher.matchesBook(BookDto.builder().isbn(1L).title("book1").authors("author1").yearRead(2020).build()),
				BookMatcher.matchesBook(BookDto.builder().isbn(2L).title("book2").authors("author2").yearRead(2019).build()),
				BookMatcher.matchesBook(BookDto.builder().isbn(3L).title("book3").authors("author3").yearRead(2018).build()))
		);
	}

	@Test
	void givenNoRole_FindBooksReturnsUnauthorized() {
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
			return new ObjectMapper()
					.convertValue(item, BookDto.class)
					.equals(expectedBook);
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("\n\t{"
					+ "\n\t\tyearRead=" + expectedBook.getYearRead() + ", "
					+ "\n\t\tisbn=" + expectedBook.getIsbn() + ", "
					+ "\n\t\ttitle=" + expectedBook.getTitle() + ", "
					+ "\n\t\tauthors=" + expectedBook.getAuthors() + ""
					+ "\n\t}");
		}
	}
}
