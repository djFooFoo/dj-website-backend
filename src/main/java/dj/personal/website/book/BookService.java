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
	private final BookCoverRepository bookCoverRepository;

	@Autowired
	public BookService(BookRepository bookRepository, BookCoverRepository bookCoverRepository) {
		this.bookRepository = bookRepository;
		this.bookCoverRepository = bookCoverRepository;
	}

	public Collection<BookDto> getBooks() {
		return bookRepository.findAll()
				.stream()
				.map(book -> {
					BookDto bookDto = book.toDTO();
					bookDto.setBase64image(bookCoverRepository.findByBook(book).get().getBase64image());
					return bookDto;
				})
				.sorted(Comparator.comparing(BookDto::getYearRead).reversed().thenComparing(BookDto::getTitle))
				.collect(toList());
	}
}
