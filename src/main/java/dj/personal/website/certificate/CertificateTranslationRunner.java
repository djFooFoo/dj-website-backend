package dj.personal.website.certificate;

import static dj.personal.website.translation.ApplicationLocale.EN;
import static dj.personal.website.translation.ApplicationLocale.NL;

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
@Order(1)
@Component
public class CertificateTranslationRunner implements CommandLineRunner {
	private final TranslatedValueRepository translatedValueRepository;

	@Autowired
	public CertificateTranslationRunner(TranslatedValueRepository translatedValueRepository) {
		this.translatedValueRepository = translatedValueRepository;
	}

	@Override
	public void run(String... args) {
		translateArticleTitles();
	}

	private void translateArticleTitles() {
		addTranslationsForKey("deep.learning.specialization", "Deep Learning Specialization", "Deep Learning Specialisatie");
		addTranslationsForKey("ai.for.everyone", "AI For Everyone", "AI voor iedereen");
		addTranslationsForKey("angular.challenge", "Angular Challenge Finalist", "Angular Challenge Finalist");
		addTranslationsForKey("pytorch.deep.learning", "PyTorch: Deep Learning and Artificial Intelligence", "PyTorch: Deep Learning en Artificiële Intelligentie"
		);
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

	private void addTranslationsForKey(String key, String enValue, String nlValue) {
		addForLanguage(key, EN, enValue);
		addForLanguage(key, NL, nlValue);
	}
}
