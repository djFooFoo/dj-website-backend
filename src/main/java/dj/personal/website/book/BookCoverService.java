package dj.personal.website.book;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import dj.personal.website.HttpClientComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dj
 */
@Service
@Slf4j
public class BookCoverService {

	private final String bookCoverUrl;
	private final HttpClientComponent httpClientComponent;

	@Autowired
	public BookCoverService(@Value("${book.cover.url}") String bookCoverUrl, HttpClientComponent httpClientComponent) {
		this.bookCoverUrl = bookCoverUrl;
		this.httpClientComponent = httpClientComponent;
	}

	public CompletableFuture<String> get(long isbn) {
		log.info("Retrieving book with isbn: " + isbn);
		HttpRequest request = HttpRequest.newBuilder(URI.create(bookCoverUrl + isbn))
				.GET()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();

		return httpClientComponent.performAsync(request);
	}
}
