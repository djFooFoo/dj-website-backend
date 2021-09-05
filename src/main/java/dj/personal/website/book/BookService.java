package dj.personal.website.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

/**
 * @author dj
 */
@Service
public class BookService {
	private final BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Collection<Book> getBooks() {
		return bookRepository.findAll()
				.stream()
				.sorted(Comparator.comparing(Book::getYearRead).reversed().thenComparing(Book::getTitle))
				.collect(toList());
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void deleteByIsbn(Long isbn) {
		bookRepository.deleteById(isbn);
	}
}
