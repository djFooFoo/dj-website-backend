package dj.personal.website.book;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dj
 */
@Service
@Slf4j
public class BookCoverService {

	private final String bookCoverUrl;
	private final int timeout;
	private final CloseableUrlConnection closeableUrlConnection;

	@Autowired
	public BookCoverService(@Value("${book.cover.url}") String bookCoverUrl, @Value("${book.cover.timeout}") int timeout, CloseableUrlConnection closeableUrlConnection){
		this.bookCoverUrl = bookCoverUrl;
		this.timeout = timeout;
		this.closeableUrlConnection = closeableUrlConnection;
	}

	public String get(long isbn) {
		try {
			String url = bookCoverUrl + isbn;
			HttpURLConnection connection = closeableUrlConnection.connect(url);
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
			connection.setRequestMethod("GET");

			return new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))
					.lines()
					.collect(joining());
		} catch (Exception e) {
			log.error("Could not retrieve book cover with isbn " + isbn + ".");
		}
		return null;
	}
}
