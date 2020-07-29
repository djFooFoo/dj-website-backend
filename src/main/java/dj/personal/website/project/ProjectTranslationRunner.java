package dj.personal.website.project;

import static dj.personal.website.translation.ApplicationLocale.EN;
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
@Order(1)
@Component
public class ProjectTranslationRunner implements CommandLineRunner {
	private final TranslatedValueRepository translatedValueRepository;

	@Autowired
	public ProjectTranslationRunner(TranslatedValueRepository translatedValueRepository) {
		this.translatedValueRepository = translatedValueRepository;
	}

	@Override
	public void run(String... args) {
		translateClients();
		translateJobDescriptions();
		translateJobTitles();
		translateTimestamps();
	}

	private void translateTimestamps() {
		addTranslationsForKey("fod.justice.time.span", "September 2018 - present", "September 2018 - heden", "Septembre 2018 à ce jour");
		addTranslationsForKey("ravago.time.span", "May 2017 - August 2018", "Mei 2017 - Augustus 2018", "Mai 2017 - Août 2018");
		addTranslationsForKey("bose.time.span", "October 2016 - March 2017", "Oktober 2016 - Maart 2017", "Octobre 2016 - Mars 2017");
	}

	private void translateJobTitles() {
		addTranslationsForKey("Full-Stack Developer", "Full-Stack Developer", "Full-Stack ontwikkelaar", "Développeur de pile complète");
		addTranslationsForKey("Java Developer", "Java Developer", "Java ontwikkelaar", "Développeur Java");
	}

	private void translateJobDescriptions() {
		addTranslationsForKey("fod.justice.description",
				"The development of a modern document management system. The main functionalities of this service are to allow the storage of any type of document, the annotation/tagging of "
						+ "documents, the placement of comments, the creation of associations and the advanced search on documents, tags, etc.",
				"De ontwikkeling van een modern document management systeem. De hoofdfunctionaliteiten van deze service zijn het toelaten van het opslaan van eender welk type document, het "
						+ "annoteren/taggen van documenten, het plaatsen van reacties, het leggen van associaties en het geavanceerd zoeken op documenten, tags etc.",
				"L''élaboration d''un système moderne de gestion des documents. Les principales fonctionnalités de ce service sont de permettre le stockage de tout type de document, "
						+ "l''annotation/étiquetage de documents, le placement des réponses, la création d''associations et la recherche avancée sur les documents, tags, etc.");
		addTranslationsForKey("ravago.description",
				"The development of a custom ERP tool that is used by all companies within the global <a href=\"https://www.ravago.com/\">Ravago</a> company group. The main functions of "
						+ "this system are placing orders, arranging transport and creating invoices. The biggest challenge I found here was the refactoring of often old code to a performing new "
						+ "architecture. To support the new developments, an E2E framework was built next to the application. In addition to my functions as an agile developer, I carried out deploys "
						+ "to UAT and helped with the release coordination. I was also deputy Scrum Master for a period of time.",
				"Het ontwikkelen van een custom ERP tool die door alle bedrijven binnen de wereldwijde <a href=\"https://www.ravago.com/\">Ravago</a> company group gebruikt wordt. De "
						+ "belangrijkste functies van dit systeem zijn het plaatsen van orders, het regelen van transport en het aanmaken van invoices. De grootste uitdaging vond ik hier in het "
						+ "refactoren van vaak oude code naar een performante nieuwe architectuur. Om de nieuwe ontwikkelingen te ondersteunen werd er naast de applicatie een end-to-end framework "
						+ "gebouwd. Naast mijn functies als agile developer voerde ik deploys uit naar UAT en hielp ik met de release coördinatie. Daarnaast was ik gedurende een periode "
						+ "plaatsvervangend scrum master.",
				"Le développement d''un outil ERP personnalisé qui est utilisé par toutes les sociétés du groupe mondial <a href=\"https://www.ravago.com/\">Ravago</a>. Les principales "
						+ "fonctions de ce système sont la passation des commandes, l''organisation du transport et l''établissement des factures. Le plus grand défi que j''ai trouvé ici était "
						+ "le remaniement d''un code souvent ancien en une nouvelle architecture performante. Pour soutenir les nouveaux développements, un cadre E2E a été construit à côté de "
						+ "l''application. En plus de mes fonctions de développeur agile, j''ai effectué des déploiements en UAT et aidé à la coordination des versions. J''ai aussi été scrum master "
						+ "adjoint pendant un certain temps.");
		addTranslationsForKey("bose.description",
				"Developing a global website for the companies that are customers of Bose. This <a href=\"https://reseller.bose.com/en_us/landingpage.html\">website</a> allows companies "
						+ "to place orders, perform repairs, exchange Bose products and much more. The project started in Genk and later moved to Maastricht, I was part of the agile developer team "
						+ "<a href=\"https://harrypotter.fandom.com/wiki/Alastor_Moody\">Moody</a>.",
				"Het ontwikkelen van een wereldwijde website voor de bedrijven die klant zijn bij Bose. Via deze <a href=\"https://reseller.bose.com/en_us/landingpage.html\">website</a> "
						+ "kunnen bedrijven bestellingen plaatsen, reparaties uitvoeren, Bose producten omruilen en zoveel meer. Het project startte in Genk en verhuisde later naar Maastricht, ik "
						+ "maakte deel uit van het agile developer team <a href=\"https://harrypotter.fandom.com/wiki/Alastor_Moody\">Moody</a>.",
				"Développement d''un site web mondial pour les entreprises clientes de Bose. Ce <a href=\"https://reseller.bose.com/en_us/landingpage.html\">site web</a> permet aux"
						+ " entreprises de passer des commandes, d''effectuer des réparations, d''échanger des produits Bose et bien plus encore. Le projet a commencé à Genk et s''est ensuite "
						+ "déplacé à Maastricht, je faisais partie de l''équipe de développement agile <a href=\"https://harrypotter.fandom.com/wiki/Alastor_Moody\">Moody</a>.");

	}

	private void translateClients() {
		addTranslationsForKey("fod.justice", "Federal Public Service Justice", "Federale Overheidsdienst Justitie", "Service Public Fédéral Justice");
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

	private void addTranslationsForKey(String key, String enValue, String nlValue, String frValue) {
		addForLanguage(key, EN, enValue);
		addForLanguage(key, NL, nlValue);
		addForLanguage(key, FR, frValue);
	}
}
