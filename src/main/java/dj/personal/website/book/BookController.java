package dj.personal.website.book;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dj.personal.website.Role;

@RestController()
class BookController {
	private final BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("api/book")
	@RolesAllowed(Role.ADMIN)
	public Collection<BookDTO> findAll() {
		return bookRepository.findAll()
				.stream()
				.map(Book::toDTO)
				.sorted(Comparator.comparing(BookDTO::getTitle))
				.collect(toList());
	}
}
