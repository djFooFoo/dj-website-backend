package dj.personal.website.book;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Collection<BookDto> getBooks() {
		return bookRepository.findAll()
				.stream()
				.map(Book::toDTO)
				.sorted(Comparator.comparing(BookDto::getYearRead).reversed().thenComparing(BookDto::getTitle))
				.collect(toList());
	}
}
