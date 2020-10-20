package dj.personal.website.blogpost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author dj
 */
@Order(2)
@Component
@Slf4j
public class BlogpostRunner implements CommandLineRunner {

	private final BlogpostRepository blogpostRepository;

	@Autowired
	public BlogpostRunner(BlogpostRepository blogpostRepository) {
		this.blogpostRepository = blogpostRepository;
	}

	@Override
	public void run(String... args) {
		Collection<Blogpost> blogposts = createBlogposts();

		int size = blogposts.size();
		log.info(size + " blogposts have been saved to the database.");
	}

	private Collection<Blogpost> createBlogposts() {
		List<Blogpost> blogposts = new ArrayList<>();

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.1")
				.publicationDate(LocalDate.of(2018, Month.FEBRUARY, 12))
				.url("https://www.continuum.be/2018/02/12/hey-alexa-order-us-two-pizzas-please/")
				.category("Artificial Intelligence")
				.build());

		blogposts.add(Blogpost.builder()
				.title("Machine learning on source code")
				.publicationDate(LocalDate.of(2018, Month.JUNE, 8))
				.url("https://www.continuum.be/2018/06/08/machine-learning-on-source-code/")
				.category("Artificial Intelligence")
				.build());

		blogposts.add(Blogpost.builder()
				.title("Deep Instinct – Malware detection using deep learning")
				.publicationDate(LocalDate.of(2018, Month.NOVEMBER, 2))
				.url("https://www.continuum.be/2018/11/02/deep-instinct-malware-detection-using-deep-learning/")
				.category("Artificial Intelligence")
				.build());

		blogposts.add(Blogpost.builder()
				.title("Destructuring")
				.publicationDate(LocalDate.of(2019, Month.MAY, 8))
				.url("https://www.continuum.be/2019/05/08/destructuring-javascript/")
				.category("Typescript")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.5")
				.publicationDate(LocalDate.of(2019, Month.DECEMBER, 7))
				.url("https://medium.com/better-programming/fantastic-translations-and-where-to-find-them-421ee46f59db?source=friends_link&sk=7ddb4e05714d19bcf4671fbc0856fdd1")
				.category("Angular")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.6")
				.publicationDate(LocalDate.of(2020, Month.JANUARY, 9))
				.url("https://medium.com/better-programming/how-to-create-a-websocket-in-python-b68d65dbd549?source=friends_link&sk=556dcc527edf1d277053396332a270bd")
				.category("Python")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.7")
				.publicationDate(LocalDate.of(2020, Month.JANUARY, 22))
				.url("https://medium.com/better-programming/what-goes-into-a-dockerfile-ff0ace591060?source=friends_link&sk=6a4bdaf97cb6e7e76afe8fc733a1023f")
				.category("Docker")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.8")
				.publicationDate(LocalDate.of(2020, Month.JANUARY, 29))
				.url("https://medium.com/better-programming/what-is-a-uuid-and-how-are-they-generated-17f0acbd7233?source=friends_link&sk=9a136dd22416eccab08ed346b556e6b2")
				.category("Programming")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.9")
				.publicationDate(LocalDate.of(2020, Month.FEBRUARY, 3))
				.url("https://towardsdatascience.com/top-5-ai-conferences-to-visit-in-europe-in-2020-7a6f068aff34?source=friends_link&sk=f74b76e9f6844de729e3e81cf84b57cc")
				.category("Artificial Intelligence")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.10")
				.publicationDate(LocalDate.of(2020, Month.FEBRUARY, 8))
				.url("https://medium.com/better-programming/how-to-create-an-angular-dockerfile-75c059e7f8e8?source=friends_link&sk=363c8b21aafe83e1e5f84feed047e969")
				.category("Angular")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.11")
				.publicationDate(LocalDate.of(2020, Month.FEBRUARY, 21))
				.url("https://medium.com/better-programming/what-is-modularity-in-java-b1938a2304fd?source=friends_link&sk=202d13eb91c66a8fbec5580290b89c45")
				.category("Java")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.12")
				.publicationDate(LocalDate.of(2020, Month.MARCH, 10))
				.url("https://medium.com/better-programming/how-does-docker-port-binding-work-b089f23ca4c8?source=friends_link&sk=40c9fbcdc4172bb065711ab554e9b1c2")
				.category("Docker")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.13")
				.publicationDate(LocalDate.of(2020, Month.MARCH, 22))
				.url("https://towardsdatascience.com/increase-your-face-recognition-models-accuracy-by-improving-face-contrast-a3e71bb6b9fb?source=friends_link&sk=a51fd37b38a9f9770fc424208c93a6a2")
				.category("Artificial Intelligence")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.14")
				.publicationDate(LocalDate.of(2020, Month.MARCH, 31))
				.url("https://medium.com/better-programming/test-driven-development-attempt-with-jest-and-angular-7e064b76ca2d?source=friends_link&sk=02e853220ce751e054222a67377ac804")
				.category("Angular")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.15")
				.publicationDate(LocalDate.of(2020, Month.APRIL, 20))
				.url("https://medium.com/better-programming/how-to-review-code-in-7-steps-98298003b7ec?source=friends_link&sk=648395f0913696002a267ee4f648a3c6")
				.category("Programming")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.16")
				.publicationDate(LocalDate.of(2020, Month.APRIL, 23))
				.url("https://medium.com/better-programming/decouple-tests-with-data-attributes-c920606c5f27?source=friends_link&sk=26885722b8f4f1896a157e2fb5fd060d")
				.category("Angular")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.17")
				.publicationDate(LocalDate.of(2020, Month.APRIL, 29))
				.url("https://medium.com/better-programming/how-to-create-a-generator-in-python-5ee587621879?source=friends_link&sk=0017a0f77f44b7f2e896673cfb31d18d")
				.category("Python")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.18")
				.publicationDate(LocalDate.of(2020, Month.MAY, 10))
				.url("https://towardsdatascience.com/what-is-domain-driven-design-5ea1e98285e4?source=friends_link&sk=736dd1f5a15a6a5fe324ef9e6e4dee2f")
				.category("Programming")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.19")
				.publicationDate(LocalDate.of(2020, Month.MAY, 17))
				.url("https://towardsdatascience.com/linear-classification-in-pytorch-9d8a8f8ff264?source=friends_link&sk=430b52f0839a4b697e1e0fc015ee4d68")
				.category("Artificial Intelligence")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.20")
				.publicationDate(LocalDate.of(2020, Month.JUNE, 10))
				.url("https://medium.com/better-programming/how-to-create-an-angular-pipeline-with-jenkins-8040f1a0c0ee?source=friends_link&sk=1b5c4a7723fb46f94ded85eda2e8e2e0")
				.category("Angular")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.21")
				.publicationDate(LocalDate.of(2020, Month.JUNE, 15))
				.url("https://medium.com/better-programming/how-to-create-a-star-rating-component-in-angular-ff32234ea531?source=friends_link&sk=4b636bbb2898a171844386bbac08a65e")
				.category("Angular")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.22")
				.publicationDate(LocalDate.of(2020, Month.JUNE, 23))
				.url("https://medium.com/swlh/enable-angular-google-analytics-14acac59e998?source=friends_link&sk=c4d260fbdc705b9947c665b17a8e923e")
				.category("Angular")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.23")
				.publicationDate(LocalDate.of(2020, Month.JULY, 16))
				.url("https://medium.com/better-programming/5-reasons-to-become-a-software-craftsman-86ab3d7c4cf9?source=friends_link&sk=4a76d6d5579611ef10269af91348719f")
				.category("Programming")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.24")
				.publicationDate(LocalDate.of(2020, Month.AUGUST, 17))
				.url("https://medium.com/better-programming/3-reasons-to-switch-to-fastapi-f9c788d017e5?source=friends_link&sk=746e465da51bc0af4a94fc337689a2ff")
				.category("Python")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.25")
				.publicationDate(LocalDate.of(2020, Month.SEPTEMBER, 8))
				.url("https://medium.com/better-programming/how-to-create-a-dockerfile-for-a-spring-boot-application-46878997382f?source=friends_link&sk=d7f93632a36b031d97998d15f0225b75")
				.category("Java")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.26")
				.publicationDate(LocalDate.of(2020, Month.SEPTEMBER, 24))
				.url("https://medium.com/better-programming/how-to-create-a-dockerfile-for-a-python-application-8d078b16bc9a?source=friends_link&sk=d365c0380159d068e84dd562fb60d82c")
				.category("Python")
				.build());

		blogposts.add(Blogpost.builder()
				.title("blogpost.title.27")
				.publicationDate(LocalDate.of(2020, Month.OCTOBER, 19))
				.url("https://medium.com/better-programming/what-is-a-behaviorsubject-in-rxjs-f580e934a5b2?source=friends_link&sk=4251c5d5ad45a881a6bf131fddf82846")
				.category("Angular")
				.build());

		return blogpostRepository.saveAll(blogposts);
	}
}
