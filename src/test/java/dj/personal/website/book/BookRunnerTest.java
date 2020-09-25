package dj.personal.website.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookRunnerTest {
	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookRunner bookRunner;

	@Test
	public void addsBooksToRepository() {

		bookRunner.run();

		verify(bookRepository).saveAll(anyList());
	}
}
