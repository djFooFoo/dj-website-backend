package dj.personal.website.book;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookRunnerTest {
	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookRunner bookRunner;

	@Test
	public void adds24BooksToRepository() {
		int amountOfBooks = 24;

		bookRunner.run();

		verify(bookRepository, times(amountOfBooks)).save(any(Book.class));
	}
}
