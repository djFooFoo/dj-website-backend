package dj.personal.website.blogpost;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Order(1)
@Component
@Slf4j
public class BlogpostRunner implements CommandLineRunner {

	private final BlogpostRepository blogpostRepository;
	private final BlogpostPreviewService blogpostPreviewService;

	@Autowired
	public BlogpostRunner(BlogpostRepository blogpostRepository, BlogpostPreviewService blogpostPreviewService) {
		this.blogpostRepository = blogpostRepository;
		this.blogpostPreviewService = blogpostPreviewService;
	}

	@Override
	public void run(String... args) {
		Collection<Blogpost> blogposts = createBlogposts();

		int size = blogposts.size();
		log.info(size + " blogposts have been saved to the database.");
	}

	private Collection<Blogpost> createBlogposts() {
		createAndSaveBlogpost("blogpost.title.1",  LocalDate.of(2018, Month.FEBRUARY, 12),
				"https://www.continuum.be/2018/02/12/hey-alexa-order-us-two-pizzas-please/", "Artificial Intelligence");

		createAndSaveBlogpost("Machine learning on source code",  LocalDate.of(2018, Month.JUNE, 8),
				"https://www.continuum.be/2018/06/08/machine-learning-on-source-code/", "Artificial Intelligence");

		createAndSaveBlogpost("Deep Instinct – Malware detection using deep learning",  LocalDate.of(2018, Month.NOVEMBER, 2),
				"https://www.continuum.be/2018/11/02/deep-instinct-malware-detection-using-deep-learning/", "Artificial Intelligence");

		createAndSaveBlogpost("Destructuring",  LocalDate.of(2019, Month.MAY, 8),
				"https://www.continuum.be/2019/05/08/destructuring-javascript/", "Typescript");

		createAndSaveBlogpost("blogpost.title.5",  LocalDate.of(2019, Month.DECEMBER, 7),
				"https://medium.com/better-programming/fantastic-translations-and-where-to-find-them-421ee46f59db?source=friends_link&sk=7ddb4e05714d19bcf4671fbc0856fdd1", "Angular");

		createAndSaveBlogpost("blogpost.title.6",  LocalDate.of(2020, Month.JANUARY, 9),
				"https://medium.com/better-programming/how-to-create-a-websocket-in-python-b68d65dbd549?source=friends_link&sk=556dcc527edf1d277053396332a270bd", "Python");

		createAndSaveBlogpost("blogpost.title.7",  LocalDate.of(2020, Month.JANUARY, 22),
				"https://medium.com/better-programming/what-goes-into-a-dockerfile-ff0ace591060?source=friends_link&sk=6a4bdaf97cb6e7e76afe8fc733a1023f", "Docker");

		createAndSaveBlogpost("blogpost.title.8",  LocalDate.of(2020, Month.JANUARY, 29),
				"https://medium.com/better-programming/what-is-a-uuid-and-how-are-they-generated-17f0acbd7233?source=friends_link&sk=9a136dd22416eccab08ed346b556e6b2", "Programming");

		createAndSaveBlogpost("blogpost.title.9",  LocalDate.of(2020, Month.FEBRUARY, 3),
				"https://towardsdatascience.com/top-5-ai-conferences-to-visit-in-europe-in-2020-7a6f068aff34?source=friends_link&sk=f74b76e9f6844de729e3e81cf84b57cc", "Artificial Intelligence");

		createAndSaveBlogpost("blogpost.title.10",  LocalDate.of(2020, Month.FEBRUARY, 8),
				"https://medium.com/better-programming/how-to-create-an-angular-dockerfile-75c059e7f8e8?source=friends_link&sk=363c8b21aafe83e1e5f84feed047e969", "Angular");

		createAndSaveBlogpost("blogpost.title.11",  LocalDate.of(2020, Month.FEBRUARY , 21),
				"https://medium.com/better-programming/what-is-modularity-in-java-b1938a2304fd?source=friends_link&sk=202d13eb91c66a8fbec5580290b89c45", "Java");

		createAndSaveBlogpost("blogpost.title.12",  LocalDate.of(2020, Month.MARCH, 10),
				"https://medium.com/better-programming/how-does-docker-port-binding-work-b089f23ca4c8?source=friends_link&sk=40c9fbcdc4172bb065711ab554e9b1c2", "Docker");

		createAndSaveBlogpost("blogpost.title.13",  LocalDate.of(2020, Month.MARCH , 22),
				"https://towardsdatascience.com/increase-your-face-recognition-models-accuracy-by-improving-face-contrast-a3e71bb6b9fb?source=friends_link&sk=a51fd37b38a9f9770fc424208c93a6a2", "Artificial Intelligence");

		createAndSaveBlogpost("blogpost.title.14",  LocalDate.of(2020, Month.MARCH, 31),
				"https://medium.com/better-programming/test-driven-development-attempt-with-jest-and-angular-7e064b76ca2d?source=friends_link&sk=02e853220ce751e054222a67377ac804", "Angular");

		createAndSaveBlogpost("blogpost.title.15",  LocalDate.of(2020, Month.APRIL, 20),
				"https://medium.com/better-programming/how-to-review-code-in-7-steps-98298003b7ec?source=friends_link&sk=648395f0913696002a267ee4f648a3c6", "Programming");

		createAndSaveBlogpost("blogpost.title.16",  LocalDate.of(2020, Month.APRIL, 23),
				"https://medium.com/better-programming/decouple-tests-with-data-attributes-c920606c5f27?source=friends_link&sk=26885722b8f4f1896a157e2fb5fd060d", "Angular");

		createAndSaveBlogpost("blogpost.title.17",  LocalDate.of(2020, Month.APRIL, 29),
				"https://medium.com/better-programming/how-to-create-a-generator-in-python-5ee587621879?source=friends_link&sk=0017a0f77f44b7f2e896673cfb31d18d", "Python");

		createAndSaveBlogpost("blogpost.title.18",  LocalDate.of(2020, Month.MAY, 10),
				"https://towardsdatascience.com/what-is-domain-driven-design-5ea1e98285e4?source=friends_link&sk=736dd1f5a15a6a5fe324ef9e6e4dee2f", "Programming");

		createAndSaveBlogpost("blogpost.title.19",  LocalDate.of(2020, Month.MAY, 17),
				"https://towardsdatascience.com/linear-classification-in-pytorch-9d8a8f8ff264?source=friends_link&sk=430b52f0839a4b697e1e0fc015ee4d68", "Artificial Intelligence");

		createAndSaveBlogpost("blogpost.title.20",  LocalDate.of(2020, Month.JUNE, 10),
				"https://medium.com/better-programming/how-to-create-an-angular-pipeline-with-jenkins-8040f1a0c0ee?source=friends_link&sk=1b5c4a7723fb46f94ded85eda2e8e2e0", "Angular");

		createAndSaveBlogpost("blogpost.title.21", LocalDate.of(2020, Month.JUNE, 15),
				"https://medium.com/better-programming/how-to-create-a-star-rating-component-in-angular-ff32234ea531?source=friends_link&sk=4b636bbb2898a171844386bbac08a65e", "Angular");

		createAndSaveBlogpost("blogpost.title.22", LocalDate.of(2020, Month.JUNE, 23),
				"https://medium.com/swlh/enable-angular-google-analytics-14acac59e998?source=friends_link&sk=c4d260fbdc705b9947c665b17a8e923e", "Angular");

		return blogpostRepository.findAll();
	}

	private void createAndSaveBlogpost(String title, LocalDate publicationDate, String url, String category) {
		BlogpostPreview blogpostPreview = blogpostPreviewService.get(title, url);

		Blogpost blogpost = Blogpost.builder()
				.title(title)
				.publicationDate(publicationDate)
				.url(url)
				.base64image(blogpostPreview.getImage())
				.category(category)
				.build();

		blogpostRepository.save(blogpost);
	}
}
