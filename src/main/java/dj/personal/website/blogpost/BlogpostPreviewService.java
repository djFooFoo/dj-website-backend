package dj.personal.website.blogpost;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dj.personal.website.HttpClientComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dj
 */
@Service
@Slf4j
public class BlogpostPreviewService {

	private final String blogpostDownloaderUrl;
	private final HttpClientComponent httpClientComponent;

	@Autowired
	public BlogpostPreviewService(@Value("${blogpost.downloader.url}") String blogpostDownloaderUrl, HttpClientComponent httpClientComponent) {
		this.blogpostDownloaderUrl = blogpostDownloaderUrl;
		this.httpClientComponent = httpClientComponent;
	}

	public CompletableFuture<BlogpostPreview> get(String title, String url) {
		log.info("Retrieving blogpost with link: " + url);

		var jsonPropertyMap = new HashMap<String, String>(2) {{
			put("title", title);
			put("url", url);
		}};

		String requestBody = toJsonString(jsonPropertyMap);

		HttpRequest request = HttpRequest.newBuilder(URI.create(blogpostDownloaderUrl))
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.build();

		return httpClientComponent.performAsync(request)
				.thenApply(this::toJsonNode)
				.thenApply(jsonNode -> {
					String image = jsonNode.path("image").asText();
					return new BlogpostPreview(image);
				});
		}

	private String toJsonString(HashMap<String, String> values) {
		String requestBody = null;
		try {
			requestBody = new ObjectMapper().writeValueAsString(values);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return requestBody;
	}

	private JsonNode toJsonNode(String response) {
		JsonNode parent = null;
		try {
			parent = new ObjectMapper().readTree(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return parent;
	}
}
