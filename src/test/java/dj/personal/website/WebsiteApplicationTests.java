package dj.personal.website;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebsiteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebsiteApplicationTests {
	@Test
	public void applicationContextTest() {
		WebsiteApplication.main(new String[] {});
	}
}
