package dj.personal.website.book;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dj
 */
@Order(1)
@Component
@Slf4j
public class BookRunner implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final BookCoverService bookCoverService;

	@Autowired
	public BookRunner(BookRepository bookRepository, BookCoverService bookCoverService) {
		this.bookRepository = bookRepository;
		this.bookCoverService = bookCoverService;
	}

	@Override
	public void run(String... args) {
		Collection<Book> books = createBooks();

		int size = books.size();
		log.info("A total amount of " + size + " books have been saved to the database.");
	}

	private Collection<Book> createBooks() {
		createAndSaveBook(9781451639612L, "7 Habits of highly effective people", "Stephen Covey", 2018, 3.5f);
		createAndSaveBook(9781934356340L, "The Passionate Programmer: Creating a Remarkable Career in Software Development", "Chad Fowler", 2019, 4);
		createAndSaveBook(9781118957400L, "Oracle Certified Associate Java SE 8 Programmer I Study Guide", "Jeanne Boyarsky and Scott Selikoff", 2016, 4.5f);
		createAndSaveBook(9781119067900L, "Oracle Certified Professional Java SE 8 Programmer II Study Guide", "Jeanne Boyarsky and Scott Selikoff", 2019, 3);
		createAndSaveBook(9781546376231L, "Ng-book: the complete book on Angular", "Nathan Murray, Felipe Coury, Ari Lerner and Carlos Taborda", 2019, 3.5f);
		createAndSaveBook(9780132542913L, "The Clean Coder: A code of Conduct for Professional Programmers", "Robert Cecil Martin", 2018, 4.5f);
		createAndSaveBook(9780134685991L, "Effective Java: A Programming Language Guide", "Joshua Bloch", 2019, 3.5f);
		createAndSaveBook(9780132350884L, "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert Cecil Martin", 2019, 4);
		createAndSaveBook(9780596007126L, "Head First Design Patterns: A Brain-Friendly Guide", "Elisabeth Freeman and Kathy Sierra", 2016, 4.5f);
		createAndSaveBook(9780321579362L, "Succeeding with Agile: Software Development Using Scrum", "Mike Cohn", 2017, 4);
		createAndSaveBook(9780671027032L, "How to win friends and influence people", "Dale Carnegie", 2018, 4.5f);
		createAndSaveBook(9780062803832L, "Unfu*k Yourself: Get Out of Your Head and Into Your Life", "Bishop, Gary John", 2020, 5);
		createAndSaveBook(9780134052502L, "The Software Craftsman: Professionalism, Pragmatism, Pride", "Sandro Mancuso and Robert Cecil Martin", 2020, 4.5f);
		createAndSaveBook(9780321125217L, "Domain-Driven Design: Tackling Complexity in the Heart of Software", "Eric Evans", 2020, 3);
		createAndSaveBook(9781491954164L, "Java 9 Modularity: Patterns and practices for developing maintainable applications", "Sander Mak and Paul Baker", 2019, 3.5f);
		createAndSaveBook(9781491925614L, "Fundamentals of Deep Learning", "Nicholas Locascio and Nikhil Buduma", 2018, 3);
		createAndSaveBook(9780982866917L, "The Elements of Scrum", "Christopher A. Sims and Hillary Louise Johnson", 2016, 4);
		createAndSaveBook(9780143124047L, "How to create a mind: The Secret of Human Thought Revealed", "Ray Kurzweil", 2018, 4);
		createAndSaveBook(9780987467485L, "HTML5 & CSS3 For The Real World", "Alexis Goldstein, Estelle Weyl and Louis Lazaris", 2017, 3);
		createAndSaveBook(9781449344856L, "AngularJS", "Brad Green and Shyam Seshadri", 2017, 2);
		createAndSaveBook(9781935182023L, "JUnit in Action", "Ted Husted and Vincent Massol", 2016, 3.5f);
		createAndSaveBook(9781783982516L, "Mastering Unit Testing Using Mockito, JUnit", "Sujoy Acharya", 2016, 3.5f);
		createAndSaveBook(9781617291203L, "Spring in Action", "Craig Walls", 2017, 2);
		createAndSaveBook(9781617290459L, "Java Persistence with Hibernate", "Cornelis Bauer and Gavin King", 2017, 3);

		return bookRepository.findAll();
	}

	private void createAndSaveBook(long isbn, String title, String authors, int yearRead, float rating) {
		Book book = Book.builder()
				.isbn(isbn)
				.title(title)
				.authors(authors)
				.yearRead(yearRead)
				.base64image(bookCoverService.get(isbn))
				.rating(rating)
				.build();
		bookRepository.save(book);
	}
}
