package dj.personal.website.book;

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
public class BookTitleTranslationRunner implements CommandLineRunner {
	private final TranslatedValueRepository translatedValueRepository;

	@Autowired
	public BookTitleTranslationRunner(TranslatedValueRepository translatedValueRepository) {
		this.translatedValueRepository = translatedValueRepository;
	}

	@Override
	public void run(String... args) {
		translateBookTitles();
	}

	private void translateBookTitles() {
				addTranslationsForKey("7 Habits of highly effective people",
						"De zeven eigenschappen van effectief leiderschap"
				);
				addTranslationsForKey("The Passionate Programmer: Creating a Remarkable Career in Software Development",
						"The Passionate Programmer: Het creëren van een opmerkelijke carrière in software-ontwikkeling"
				);
				addTranslationsForKey("Oracle Certified Associate Java SE 8 Programmer I Study Guide",
						"Oracle Certified Associate Java SE 8 Programmer I Studiegids"
				);
				addTranslationsForKey("Oracle Certified Professional Java SE 8 Programmer II Study Guide",
						"Oracle Certified Professional Java SE 8 Programmer II Studiegids"
				);
				addTranslationsForKey("Ng-book: the complete book on Angular",
						"Ng-book: het complete boek over Angular"
				);
				addTranslationsForKey("The Clean Coder: A code of Conduct for Professional Programmers",
						"The Clean Coder: Een gedragscode voor Professionele Programmeurs"
				);
				addTranslationsForKey("Effective Java: A Programming Language Guide",
						"Effective Java: Een programmeertaalgids"
				);
				addTranslationsForKey("Clean Code: A Handbook of Agile Software Craftsmanship",
						"Clean Code: Een Handboek van Agile Software Vakmanschap"
				);
				addTranslationsForKey("Head First Design Patterns: A Brain-Friendly Guide",
						"Head First Design Patterns: Een hersenvriendelijke gids"
				);
				addTranslationsForKey("Succeeding with Agile: Software Development Using Scrum",
						"Succeeding with Agile: Softwareontwikkeling met behulp van Scrum"
				);
				addTranslationsForKey("How to win friends and influence people",
						"Hoe je vrienden maakt en mensen beïnvloedt"
				);
				addTranslationsForKey("Unfu*k Yourself: Get Out of Your Head and Into Your Life",
						"Unfu*k Yourself: Stap uit je hoofd en in je leven"
				);
				addTranslationsForKey("The Software Craftsman: Professionalism, Pragmatism, Pride",
						"De Software Craftsman: Professionaliteit, Pragmatisme, Trotsheid"
				);
				addTranslationsForKey("Domain-Driven Design: Tackling Complexity in the Heart of Software",
						"Domain-Driven Design: Complexiteit in het hart van de software aanpakken"
				);
				addTranslationsForKey("Java 9 Modularity: Patterns and practices for developing maintainable applications",
						"Java 9 Modulariteit: Patronen en werkwijzen voor het ontwikkelen van onderhoudbare applicaties"
				);
				addTranslationsForKey("Fundamentals of Deep Learning",
						"Grondbeginselen van Deep Learning"
				);
				addTranslationsForKey("The Elements of Scrum",
						"De elementen van scrum"
				);
				addTranslationsForKey("How to create a mind: The Secret of Human Thought Revealed",
						"How to create a mind: Het geheim van de menselijke gedachte onthuld"
				);
				addTranslationsForKey("HTML5 & CSS3 For The Real World",
						"HTML5 & CSS3 voor de Echte Wereld"
				);
				addTranslationsForKey("AngularJS",
						"AngularJS"
				);
				addTranslationsForKey("JUnit in Action",
						"JUnit in actie"
				);
				addTranslationsForKey("Mastering Unit Testing Using Mockito, JUnit",
						"Unit testen onder de knie krijgen met behulp van Mockito, JUnit"
				);
				addTranslationsForKey("Spring in Action",
						"Spring in Actie"
				);
				addTranslationsForKey("Java Persistence with Hibernate",
						"Java Persistentie met Hibernate"
				);
				addTranslationsForKey("Working Effectively with Legacy Code",
						"Effectief Werken met Legacy Code"
				);
				addTranslationsForKey("Clean Architecture: A Craftsman's Guide to Software Structure and Design",
						"Clean Architecture: Een Vakmansgids voor Softwarestructuur en -Ontwerp"
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

	private void addTranslationsForKey(String key, String nlValue) {
		addForLanguage(key, NL, nlValue);
	}
}
