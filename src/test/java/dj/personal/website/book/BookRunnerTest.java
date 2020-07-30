package dj.personal.website.book;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookRunnerTest {
	@Mock
	private BookRepository bookRepository;

	@Mock
	private BookCoverService bookCoverService;

	@InjectMocks
	private BookRunner bookRunner;

	@Test
	public void adds24BooksToRepository() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		completableFuture.complete("result");
		when(bookCoverService.get(any(Long.class))).thenReturn(completableFuture);
		int amountOfBooks = 24;

		bookRunner.run();

		verify(bookRepository, times(amountOfBooks)).save(any(Book.class));
	}
}
