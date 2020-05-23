package dj.personal.website.book;

import java.util.Collection;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dj.personal.website.Role;

@RestController()
@RequestMapping(path = "api/books")
class BookController {
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(Role.ADMIN)
	public Collection<BookDto> findAll() {
		return bookService.getBooks();
	}
}
