package dj.personal.website.book;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dj.personal.website.translation.TranslatedValue;
import dj.personal.website.translation.TranslatedValueRepository;

@ExtendWith(MockitoExtension.class)
public class BookTitleTranslationRunnerTest {
	@Mock
	private TranslatedValueRepository translatedValueRepository;

	@InjectMocks
	private BookTitleTranslationRunner bookTitleTranslationRunner;

	@Test
	public void addsNlAndFrTranslationForEveryBook() {
		int amountOfTranslationsExpected = 2 * 26;

		bookTitleTranslationRunner.run();

		verify(translatedValueRepository, times(amountOfTranslationsExpected)).save(any(TranslatedValue.class));
	}
}
