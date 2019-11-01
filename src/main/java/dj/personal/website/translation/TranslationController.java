package dj.personal.website.translation;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dj.personal.website.Role;

@RestController()
class TranslationController {
	private final TranslatedValueRepository translatedValueRepository;

	@Autowired
	public TranslationController(TranslatedValueRepository translatedValueRepository) {
		this.translatedValueRepository = translatedValueRepository;
	}

	@GetMapping("api/translation")
	@RolesAllowed(Role.ADMIN)
	public TranslationDTO findAll() {
		Map<ApplicationLocale, Map<String, String>> translationsForEachLocale = Arrays.stream(ApplicationLocale.values())
				.map(this::createApplicationLocaleAndKeyValuesPair)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		return new TranslationDTO(translationsForEachLocale);
	}

	private AbstractMap.SimpleEntry<ApplicationLocale, Map<String, String>> createApplicationLocaleAndKeyValuesPair(ApplicationLocale applicationLocale) {
		return new AbstractMap.SimpleEntry<>(applicationLocale, getKeyValuesForLocale(applicationLocale));
	}

	private Map<String, String> getKeyValuesForLocale(ApplicationLocale applicationLocale) {
		return translatedValueRepository
				.findByLanguageKeyLanguage(applicationLocale.toValue())
				.stream()
				.map(TranslatedValue::createKeyAndValuePair)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}
}
