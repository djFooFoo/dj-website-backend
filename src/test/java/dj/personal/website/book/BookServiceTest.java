package dj.personal.website.book;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	@Test
	public void getBooks_sortsOnYearReadDescending() {
		List<Book> books = asList(
				Book.builder().yearRead(2003).title("Magnificent Book").build(),
				Book.builder().yearRead(2004).title("Fun book").build(),
				Book.builder().yearRead(2002).title("Bad book").build()
		);

		when(bookRepository.findAll()).thenReturn(books);

		assertThat(bookService.getBooks()).isEqualTo(asList(
				BookDto.builder().yearRead(2004).title("Fun book").build(),
				BookDto.builder().yearRead(2003).title("Magnificent Book").build(),
				BookDto.builder().yearRead(2002).title("Bad book").build())
		);
	}

	@Test
	public void getBooks_sortsOnTitleIfSameYear() {
		int sameYear = 2002;

		List<Book> books = asList(
				Book.builder().yearRead(sameYear).title("aBook").build(),
				Book.builder().yearRead(sameYear).title("cBook").build(),
				Book.builder().yearRead(sameYear).title("bBook").build()
		);

		when(bookRepository.findAll()).thenReturn(books);

		assertThat(bookService.getBooks()).isEqualTo(asList(
				BookDto.builder().yearRead(sameYear).title("aBook").build(),
				BookDto.builder().yearRead(sameYear).title("bBook").build(),
				BookDto.builder().yearRead(sameYear).title("cBook").build())
		);
	}
}
