package dj.personal.website.blogpost;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dj.personal.website.CloseableUrlConnection;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BlogpostPreviewService {

	private final String blogpostDownloaderUrl;
	private final int timeout;
	private final CloseableUrlConnection closeableUrlConnection;

	@Autowired
	public BlogpostPreviewService(@Value("${blogpost.downloader.url}") String blogpostDownloaderUrl, @Value("${blogpost.timeout}") int timeout, CloseableUrlConnection closeableUrlConnection) {
		this.blogpostDownloaderUrl = blogpostDownloaderUrl;
		this.timeout = timeout;
		this.closeableUrlConnection = closeableUrlConnection;
	}

	public String get(String title, String link) {
		log.info("Retrieving blogpost with link: " + link);
		try {
			String url = blogpostDownloaderUrl;
			HttpURLConnection connection = closeableUrlConnection.connect(url);
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setRequestProperty("Accept", "application/json");
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			String jsonInputString = "{\n" + "\"title\": \"" + title + "\",\n" + "\"url\": \"" + link + "\"\n}";
			try(OutputStream os = connection.getOutputStream()) {
				byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);
			}

			String jsonString = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))
					.lines()
					.collect(joining());

			final JsonNode parent = new ObjectMapper().readTree(jsonString);

			return parent.path("image").asText();

		} catch (Exception e) {
			log.error("Could not retrieve blogpost with link " + link + ".");
		}
		return null;
	}
}
