package dj.personal.website.book;

import static dj.personal.website.translation.ApplicationLocale.FR;
import static dj.personal.website.translation.ApplicationLocale.NL;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dj.personal.website.translation.ApplicationLocale;
import dj.personal.website.translation.LanguageKey;
import dj.personal.website.translation.TranslatedValue;
import dj.personal.website.translation.TranslatedValueRepository;

/**
 * @author dj
 */
@Order(3)
@Component
public class BookAuthorsTranslationRunner implements CommandLineRunner {
	private final BookRepository bookRepository;
	private final TranslatedValueRepository translatedValueRepository;

	@Autowired
	public BookAuthorsTranslationRunner(BookRepository bookRepository, TranslatedValueRepository translatedValueRepository) {
		this.bookRepository = bookRepository;
		this.translatedValueRepository = translatedValueRepository;
	}

	@Override
	public void run(String... args) {
		List<Book> books = bookRepository.findAll();
		translateTheWordAndForBookAuthors(books);
	}

	private void translateTheWordAndForBookAuthors(Collection<Book> books) {
		String regexMatchingAnd = "\\band\\b";
		books
				.stream()
				.map(Book::getAuthors)
				.distinct()
				.filter(authors -> Pattern.compile(regexMatchingAnd).matcher(authors).find())
				.forEach(authors -> addTranslationsForKey(
						authors,
						authors.replaceAll(regexMatchingAnd, "en"),
						authors.replaceAll(regexMatchingAnd, "et")
				));
	}

	private void addForLanguage(String key, ApplicationLocale locale, String value) {
		String language = locale.toValue();

		LanguageKey languageKey = LanguageKey.builder()
				.language(language)
				.key(key)
				.build();

		TranslatedValue translatedValue = TranslatedValue.builder()
				.languageKey(languageKey)
				.value(value)
				.build();

		translatedValueRepository.save(translatedValue);
	}

	private void addTranslationsForKey(String key, String nlValue, String frValue) {
		addForLanguage(key, NL, nlValue);
		addForLanguage(key, FR, frValue);
	}
}
