package dj.personal.website.book;

import static dj.personal.website.translation.ApplicationLocale.FR;
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
@Order(2)
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
						"De zeven eigenschappen van effectief leiderschap",
						"Les 7 habitudes de ceux qui réalisent tout ce qu'ils entreprennent");
				addTranslationsForKey("The Passionate Programmer: Creating a Remarkable Career in Software Development",
						"The Passionate Programmer: Het creëren van een opmerkelijke carrière in software-ontwikkeling",
						"The Passionate Programmer : Créer une carrière remarquable dans le développement de logiciels");
				addTranslationsForKey("Oracle Certified Associate Java SE 8 Programmer I Study Guide",
						"Oracle Certified Associate Java SE 8 Programmer I Studiegids",
						"Oracle Certified Associate Java SE 8 Programmer I Guide d''étude");
				addTranslationsForKey("Oracle Certified Professional Java SE 8 Programmer II Study Guide",
						"Oracle Certified Professional Java SE 8 Programmer II Studiegids",
						"Oracle Certified Professional Java SE 8 Programmer II Guide d''étude");
				addTranslationsForKey("Ng-book: the complete book on Angular",
						"Ng-book: het complete boek over Angular",
						"Ng-book: le livre complet sur Angular");
				addTranslationsForKey("The Clean Coder: A code of Conduct for Professional Programmers",
						"The Clean Coder: Een gedragscode voor Professionele Programmeurs",
						"The Clean Coder: Un code de conduite pour les Programmeurs Professionnels");
				addTranslationsForKey("Effective Java: A Programming Language Guide",
						"Effective Java: Een programmeertaalgids",
						"Effective Java: Guide du langage de programmatione");
				addTranslationsForKey("Clean Code: A Handbook of Agile Software Craftsmanship",
						"Clean Code: Een Handboek van Agile Software Vakmanschap",
						"Clean Code: Un manuel d''Agile Software Craftsmanship");
				addTranslationsForKey("Head First Design Patterns: A Brain-Friendly Guide",
						"Head First Design Patterns: Een hersenvriendelijke gids",
						"Head First Design Patterns: Un guide convivial pour le cerveau");
				addTranslationsForKey("Succeeding with Agile: Software Development Using Scrum",
						"Succeeding with Agile: Softwareontwikkeling met behulp van Scrum",
						"Succeeding with Agile: Développement de logiciels à l''aide de Scrum");
				addTranslationsForKey("How to win friends and influence people",
						"Hoe je vrienden maakt en mensen beïnvloedt",
						"Comment se faire des amis et influencer les autres");
				addTranslationsForKey("Unfu*k Yourself: Get Out of Your Head and Into Your Life",
						"Unfu*k Yourself: Stap uit je hoofd en in je leven",
						"Unfu*k Yourself: Sortez de votre tête et entrez dans votre vie");
				addTranslationsForKey("The Software Craftsman: Professionalism, Pragmatism, Pride",
						"De Software Craftsman: Professionaliteit, Pragmatisme, Trotsheid",
						"L''artisan du logiciel : Professionnalisme, Pragmatisme, Fierté");
				addTranslationsForKey("Domain-Driven Design: Tackling Complexity in the Heart of Software",
						"Domain-Driven Design: Complexiteit in het hart van de software aanpakken",
						"Domain-Driven Design: S''attaquer à la complexité au cœur du logiciel");
				addTranslationsForKey("Java 9 Modularity: Patterns and practices for developing maintainable applications",
						"Java 9 Modulariteit: Patronen en werkwijzen voor het ontwikkelen van onderhoudbare applicaties",
						"Modularité de Java 9 : Modèles et pratiques pour le développement d'applications maintenables");
				addTranslationsForKey("Fundamentals of Deep Learning",
						"Grondbeginselen van Deep Learning",
						"Les bases de le Deep Learning");
				addTranslationsForKey("The Elements of Scrum",
						"De elementen van scrum",
						"Les éléments de la mêlée");
				addTranslationsForKey("How to create a mind: The Secret of Human Thought Revealed",
						"How to create a mind: Het geheim van de menselijke gedachte onthuld",
						"How to create a mind: Le secret de la pensée humaine dévoilé");
				addTranslationsForKey("HTML5 & CSS3 For The Real World",
						"HTML5 & CSS3 voor de Echte Wereld",
						"HTML5 & CSS3 pour le Monde Réel");
				addTranslationsForKey("AngularJS",
						"AngularJS",
						"AngularJS");
				addTranslationsForKey("JUnit in Action",
						"JUnit in actie",
						"JUnit en Action");
				addTranslationsForKey("Mastering Unit Testing Using Mockito, JUnit",
						"Unit testen onder de knie krijgen met behulp van Mockito, JUnit",
						"Test de l'unité maîtresse à l'aide de Mockito, JUnit");
				addTranslationsForKey("Spring in Action",
						"Spring in Actie",
						"Spring en Action");
				addTranslationsForKey("Java Persistence with Hibernate",
						"Java Persistentie met Hibernate",
						"Java Persistance avec Hibernate");
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
