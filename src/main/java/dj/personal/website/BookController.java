package dj.personal.website;

import static java.util.stream.Collectors.*;

import java.util.Collection;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
				.collect(toList());
	}
}
