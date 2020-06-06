package dj.personal.website.book;

import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

/**
 * @author dj
 */
@Component
public class CloseableUrlConnection implements Closeable {

	private HttpURLConnection urlConnection;

	public HttpURLConnection connect(String url) throws IOException {
		urlConnection = (HttpURLConnection) new URL(url).openConnection();
		return urlConnection;
	}

	@Override
	public void close() {
		urlConnection.disconnect();
	}
}
