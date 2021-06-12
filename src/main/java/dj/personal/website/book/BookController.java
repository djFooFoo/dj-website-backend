package dj.personal.website.book;

import dj.personal.website.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/books")
class BookController {
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(Role.ADMIN)
	public Collection<Book> findAll() {
		return bookService.getBooks();
	}

	@PutMapping
	@RolesAllowed(Role.ADMIN)
	public Book save(@RequestBody Book book) {
		return bookService.save(book);
	}

	@DeleteMapping(path = "/{isbn}")
	@RolesAllowed(Role.ADMIN)
	public void delete(@PathVariable Long isbn){
		bookService.deleteByIsbn(isbn);
	}
}
