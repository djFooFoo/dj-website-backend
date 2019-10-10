package dj.personal.website;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class BookController {
	private final BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("api/books")
	@RolesAllowed(Roles.WEBSITE_ADMIN)
	public Collection<BookDTO> findAll() {
		return bookRepository.findAll()
				.stream()
				.sorted(Book::compareTo)
				.map(Book::toDTO)
				.collect(toList());
	}
}
