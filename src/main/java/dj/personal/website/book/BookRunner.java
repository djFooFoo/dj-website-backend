package dj.personal.website.book;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dj
 */
@Order(2)
@Component
@Slf4j
public class BookRunner implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final BookCoverRepository bookCoverRepository;
	private final BookCoverService bookCoverService;

	@Autowired
	public BookRunner(BookRepository bookRepository, BookCoverRepository bookCoverRepository, BookCoverService bookCoverService) {
		this.bookRepository = bookRepository;
		this.bookCoverRepository = bookCoverRepository;
		this.bookCoverService = bookCoverService;
	}

	@Override
	public void run(String... args) {
		Collection<Book> books = createBooks();
		log.info(books.size() + " books have been saved to the database.");

		Collection<BookCover> bookCovers = createBookCovers(books);
		log.info(bookCovers.size() + " book covers have been saved to the database.");
	}

	private Collection<Book> createBooks() {
		List<Book> books = new ArrayList<>();

		books.add(Book.builder()
				.isbn(9781451639612L)
				.title("7 Habits of highly effective people")
				.authors("Stephen Covey")
				.yearRead(2018)
				.rating(3.5f)
				.build());

		books.add(Book.builder()
				.isbn(9781934356340L)
				.title("The Passionate Programmer: Creating a Remarkable Career in Software Development")
				.authors("Chad Fowler")
				.yearRead(2019)
				.rating(4f)
				.build());

		books.add(Book.builder()
				.isbn(9781118957400L)
				.title("Oracle Certified Associate Java SE 8 Programmer I Study Guide")
				.authors("Jeanne Boyarsky and Scott Selikoff")
				.yearRead(2016)
				.rating(4.5f)
				.build());

		books.add(Book.builder()
				.isbn(9781119067900L)
				.title("Oracle Certified Professional Java SE 8 Programmer II Study Guide")
				.authors("Jeanne Boyarsky and Scott Selikoff")
				.yearRead(2019)
				.rating(3f)
				.build());

		books.add(Book.builder()
				.isbn(9781546376231L)
				.title("Ng-book: the complete book on Angular")
				.authors("Nathan Murray, Felipe Coury, Ari Lerner and Carlos Taborda")
				.yearRead(2019)
				.rating(3.5f)
				.build());

		books.add(Book.builder()
				.isbn(9780132542913L)
				.title("The Clean Coder: A code of Conduct for Professional Programmers")
				.authors("Robert Cecil Martin")
				.yearRead(2018)
				.rating(4.5f)
				.build());

		books.add(Book.builder()
				.isbn(9780134685991L)
				.title("Effective Java: A Programming Language Guide")
				.authors("Joshua Bloch")
				.yearRead(2019)
				.rating(3.5f)
				.build());

		books.add(Book.builder()
				.isbn(9780132350884L)
				.title("Clean Code: A Handbook of Agile Software Craftsmanship")
				.authors("Robert Cecil Martin")
				.yearRead(2019)
				.rating(4f)
				.build());

		books.add(Book.builder()
				.isbn(9780596007126L)
				.title("Head First Design Patterns: A Brain-Friendly Guide")
				.authors("Elisabeth Freeman and Kathy Sierra")
				.yearRead(2016)
				.rating(4.5f)
				.build());

		books.add(Book.builder()
				.isbn(9780321579362L)
				.title("Succeeding with Agile: Software Development Using Scrum")
				.authors("Mike Cohn")
				.yearRead(2017)
				.rating(4f)
				.build());

		books.add(Book.builder()
				.isbn(9780671027032L)
				.title("How to win friends and influence people")
				.authors("Dale Carnegie")
				.yearRead(2018)
				.rating(4.5f)
				.build());

		books.add(Book.builder()
				.isbn(9780062803832L)
				.title("Unfu*k Yourself: Get Out of Your Head and Into Your Life")
				.authors("Bishop, Gary John")
				.yearRead(2020)
				.rating(5f)
				.build());

		books.add(Book.builder()
				.isbn(9780134052502L)
				.title("The Software Craftsman: Professionalism, Pragmatism, Pride")
				.authors("Sandro Mancuso and Robert Cecil Martin")
				.yearRead(2020)
				.rating(4.5f)
				.build());

		books.add(Book.builder()
				.isbn(9780321125217L)
				.title("Domain-Driven Design: Tackling Complexity in the Heart of Software")
				.authors("Eric Evans")
				.yearRead(2020)
				.rating(3f)
				.build());

		books.add(Book.builder()
				.isbn(9781491954164L)
				.title("Java 9 Modularity: Patterns and practices for developing maintainable applications")
				.authors("Sander Mak and Paul Baker")
				.yearRead(2019)
				.rating(3.5f)
				.build());

		books.add(Book.builder()
				.isbn(9781491925614L)
				.title("Fundamentals of Deep Learning")
				.authors("Nicholas Locascio and Nikhil Buduma")
				.yearRead(2018)
				.rating(3f)
				.build());

		books.add(Book.builder()
				.isbn(9780982866917L)
				.title("The Elements of Scrum")
				.authors("Christopher A. Sims and Hillary Louise Johnson")
				.yearRead(2016)
				.rating(4f)
				.build());

		books.add(Book.builder()
				.isbn(9780143124047L)
				.title("How to create a mind: The Secret of Human Thought Revealed")
				.authors("Ray Kurzweil")
				.yearRead(2018)
				.rating(4f)
				.build());

		books.add(Book.builder()
				.isbn(9780987467485L)
				.title("HTML5 & CSS3 For The Real World")
				.authors("Alexis Goldstein, Estelle Weyl and Louis Lazaris")
				.yearRead(2017)
				.rating(3f)
				.build());

		books.add(Book.builder()
				.isbn(9781449344856L)
				.title("AngularJS")
				.authors("Brad Green and Shyam Seshadri")
				.yearRead(2017)
				.rating(2f)
				.build());

		books.add(Book.builder()
				.isbn(9781935182023L)
				.title("JUnit in Action")
				.authors("Ted Husted and Vincent Massol")
				.yearRead(2016)
				.rating(3.5f)
				.build());

		books.add(Book.builder()
				.isbn(9781783982516L)
				.title("Mastering Unit Testing Using Mockito, JUnit")
				.authors("Sujoy Acharya")
				.yearRead(2016)
				.rating(3.5f)
				.build());

		books.add(Book.builder()
				.isbn(9781617291203L)
				.title("Spring in Action")
				.authors("Craig Walls")
				.yearRead(2017)
				.rating(2f)
				.build());

		books.add(Book.builder()
				.isbn(9781617290459L)
				.title("Java Persistence with Hibernate")
				.authors("Cornelis Bauer and Gavin King")
				.yearRead(2017)
				.rating(3f)
				.build());

		return bookRepository.saveAll(books);
	}

	private Collection<BookCover> createBookCovers(Collection<Book> books){
		List<BookCover> bookCovers = books.parallelStream()
				.map(book -> BookCover.builder()
						.book(book)
						.base64image(bookCoverService.get(book.getIsbn()).join())
						.build()
				)
				.collect(toList());
		return bookCoverRepository.saveAll(bookCovers);
	}
}
