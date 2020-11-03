package dj.personal.website.article;

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
public class ArticleTitleTranslationRunner implements CommandLineRunner {
	private final TranslatedValueRepository translatedValueRepository;

	@Autowired
	public ArticleTitleTranslationRunner(TranslatedValueRepository translatedValueRepository) {
		this.translatedValueRepository = translatedValueRepository;
	}

	@Override
	public void run(String... args) {
		translateArticleTitles();
	}

	private void translateArticleTitles() {
		addTranslationsForKey("article.title.1", "Hey Alexa! Order us two pizzas please", "Hey Alexa! Bestel ons twee pizza's alstublieft.", "Hé Alexa! Commandez-nous deux pizzas s'il vous plaît.");
		addTranslationsForKey("article.title.2", "Machine learning on source code", "Machine learning op source code", "Machine learning sur le code source");
		addTranslationsForKey("article.title.3", "Deep Instinct – Malware detection using deep learning", "Deep Instinct – Malware detectie met behulp van deep learning", "Deep Instinct – La détection des logiciels malveillants en utilisant deep learning");
		addTranslationsForKey("article.title.4", "Destructuring", "Destructuring", "Destructuring");
		addTranslationsForKey("article.title.5", "Angular & Ngx-Translate", "Angular & Ngx-Translate", "Angular & Ngx-Translate");
		addTranslationsForKey("article.title.6", "How To Create a WebSocket in Python", "Hoe maak je een WebSocket in Python", "Comment créer un WebSocket en Python");
		addTranslationsForKey("article.title.7", "What goes into a Dockerfile?", "Wat gaat er in een Dockerfile?", "Que contient un Dockerfile?");
		addTranslationsForKey("article.title.8", "What Is a UUID and How Are They Generated?", "Wat is een UUID en hoe worden ze gegenereerd?", "Qu'est-ce qu'une UUID et comment est-elle générée?");
		addTranslationsForKey("article.title.9", "Top 5 AI Conferences To Visit in Europe in 2020", "Top 5 AI-conferenties te bezoeken in Europa in 2020", "Les 5 plus grandes conférences sur l'IA à visiter en Europe en 2020.");
		addTranslationsForKey("article.title.10", "How to Create an Angular Dockerfile?", "Hoe maak je een Angular Dockerfile aan?", "Comment créer un fichier de docker pour Angular?");
		addTranslationsForKey("article.title.11", "What Is Modularity in Java?", "Wat betekenen modules in Java?", "Qu'est-ce que la modularité à Java?");
		addTranslationsForKey("article.title.12", "How Does Docker Port Binding Work?", "Hoe werkt Docker Port Binding?", "Comment fonctionne Docker Port Binding?");
		addTranslationsForKey("article.title.13", "Increase Your Face Recognition Model’s Accuracy by Improving Face Contrast", "Verhoog de nauwkeurigheid van uw gezichtsherkenningsmodel door het gezichtscontrast te verbeteren", "Augmentez la précision de votre modèle de reconnaissance faciale en améliorant le contraste des visages");
		addTranslationsForKey("article.title.14", "Test-Driven Development Attempt With Jest and Angular", "Test-Driven Development Poging Met Jest en Angular", "Tentative de développement piloté par les tests avec Jest et Angular");
		addTranslationsForKey("article.title.15", "How to Review Code in 7 Steps", "Hoe review je code in 7 stappen", "Comment réviser le code en 7 étapes");
		addTranslationsForKey("article.title.16", "Decouple Your Styling and Tests With Data Attributes", "Styling en tests ontkoppelen met data attributen", "Découplez votre style et vos tests avec des attributs de données");
		addTranslationsForKey("article.title.17", "How to Create a Generator in Python", "Hoe maak je een Generator in Python", "Comment créer un générateur en Python");
		addTranslationsForKey("article.title.18", "What is Domain-Driven Design?", "Wat is Domain-Driven Design?", "Qu'est-ce que le Domain-Driven Design?");
		addTranslationsForKey("article.title.19", "Linear Classification in Pytorch", "Lineaire Classificatie in Pytorch", "Classification Linéaire dans Pytorch");
		addTranslationsForKey("article.title.20", "How to Create an Angular Pipeline With Jenkins", "Hoe maak je een Angular Pipeline met Jenkins", "Comment créer un pipeline d''Angular avec Jenkins");
		addTranslationsForKey("article.title.21", "How to Create a Star Rating Component in Angular", "Hoe maak je een Star Rating Component in Angular", "Comment créer un élément de classement par étoiles avec Angular");
		addTranslationsForKey("article.title.22", "How To Use Google Analytics in Angular?", "Hoe gebruik je Google Analytics in Angular?", "Comment utiliser Google Analytics de manière angulaire?");
		addTranslationsForKey("article.title.23", "5 Reasons to Become a Software Craftsman", "5 Redenen om een Software Craftsman te worden", "5 raisons de devenir un Software Craftsman");
		addTranslationsForKey("article.title.24", "3 Reasons to Switch to FastAPI", "3 Redenen om over te schakelen naar FastAPI", "3 raisons de passer à FastAPI");
		addTranslationsForKey("article.title.25", "How to Create a DockerFile for a Spring Boot Application", "Hoe maak je een DockerFile voor een Spring Boot Applicatie", "Comment créer un DockerFile pour une application de Spring Boot");
		addTranslationsForKey("article.title.26", "How to Create a DockerFile for a Python Application", "Hoe maak je een DockerFile voor een Python Applicatie", "Comment créer un DockerFile pour une application de Python");
		addTranslationsForKey("article.title.27", "What Is a BehaviorSubject in RxJs?", "Wat Is een BehaviorSubject in RxJs?", "Qu'est-ce qu'un BehaviorSubject dan RxJs?");
		addTranslationsForKey("article.title.28", "The 6 Qualities of a Great Software Crafter", "De 6 Kwaliteiten van een Geweldige Software Crafter", "Les 6 qualités d'un grand créateur de logiciels");
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
