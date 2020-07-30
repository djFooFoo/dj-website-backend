package dj.personal.website.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.http.HttpRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dj.personal.website.HttpClientComponent;

@ExtendWith(MockitoExtension.class)
public class BookCoverServiceTest {
	private BookCoverService bookCoverService;

	@Mock
	private HttpClientComponent httpClientComponent;

	@BeforeEach
	void setUp() {
		bookCoverService = new BookCoverService("http://book-cover-url/", httpClientComponent);
	}

	@Test
	public void returnsNullWhenBookCannotBeFound() {
		int isbn = 666;

		when(httpClientComponent.performAsync(any(HttpRequest.class))).thenReturn(null);

		assertThat(bookCoverService.get(isbn)).isEqualTo(null);
	}

//	@Test
//	public void returnsBookWhenBookCanBeFound() {
//		int isbn = 5000;
//		String expectedBookCover = "our book cover";
//
//		when(httpClientComponent.performAsync(any(HttpRequest.class))).thenReturn(expectedBookCover);
//
//		assertThat(bookCoverService.get(isbn)).isEqualTo(expectedBookCover);
//	}
}
