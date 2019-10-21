package dj.personal.website;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;

@SpringBootTest(classes = WebsiteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookControllerTest {

	private static final JsonPathResultMatchers JSON_PATH_ALL_TITLES = jsonPath("$[*].title");
	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(username = "jos de admin", roles = "website-admin")
	void findAllBooksReturnsAllBooksReadInProfessionalCareer() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = get("/api/book");

		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(JSON_PATH_ALL_TITLES.value(equalTo(allBooksReadInProfessionalCareer())));
	}

	private List<String> allBooksReadInProfessionalCareer() throws IOException {
		return Files.readAllLines(Paths.get("src/test/resources/allMyBooks.txt"));
	}

	@Test
	void unauthorizedWhenNotHavingWebsiteAdminRole() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = get("/api/book");

		mockMvc.perform(requestBuilder)
				.andExpect(status().isUnauthorized());
	}

}
