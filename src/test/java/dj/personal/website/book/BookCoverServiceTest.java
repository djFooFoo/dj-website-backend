package dj.personal.website.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dj.personal.website.CloseableUrlConnection;

@ExtendWith(MockitoExtension.class)
public class BookCoverServiceTest {

	@Mock
	private CloseableUrlConnection closeableUrlConnection;

	private BookCoverService bookCoverService;

	@BeforeEach
	void setUp() {
		bookCoverService = new BookCoverService("http://book-cover-url/", 500, closeableUrlConnection);
	}

	@Test
	public void returnsNullWhenBookCannotBeFound() {
		assertThat(bookCoverService.get(5000)).isNull();
	}

	@Test
	public void returnsBookWhenBookCanBeFound() throws IOException {
		int isbn = 5000;
		String expectedBookCover = "our book cover";

		InputStream targetStream = new ByteArrayInputStream(expectedBookCover.getBytes());
		HttpURLConnection httpURLConnection = mock(HttpURLConnection.class);
		String bookCoverUrl = "http://book-cover-url/5000";
		when(closeableUrlConnection.connect(bookCoverUrl)).thenReturn(httpURLConnection);
		when(httpURLConnection.getInputStream()).thenReturn(targetStream);

		assertThat(bookCoverService.get(isbn)).isEqualTo(expectedBookCover);
	}
}
