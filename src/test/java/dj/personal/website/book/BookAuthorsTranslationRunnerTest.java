package dj.personal.website.book;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dj.personal.website.translation.TranslatedValue;
import dj.personal.website.translation.TranslatedValueRepository;

@ExtendWith(MockitoExtension.class)
public class BookAuthorsTranslationRunnerTest {
	@Mock
	private BookRepository bookRepository;

	@Mock
	private TranslatedValueRepository translatedValueRepository;

	@InjectMocks
	private BookAuthorsTranslationRunner bookAuthorsTranslationRunner;

	@Test
	public void addsNlAndFrAuthorTranslationForBookAuthorsContainingAnd() {
		when(bookRepository.findAll()).thenReturn(singletonList(Book.builder().authors("Dieter and Jos").build()));

		bookAuthorsTranslationRunner.run();

		verify(translatedValueRepository, times(2)).save(any(TranslatedValue.class));
	}
}
