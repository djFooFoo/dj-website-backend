package dj.personal.website.translation;

import java.io.Serializable;
import java.util.AbstractMap;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
class TranslatedValue {
	@EmbeddedId
	private LanguageKey languageKey;

	private String value;

	AbstractMap.SimpleEntry<String, String> createKeyAndValuePair() {
		return new AbstractMap.SimpleEntry<>(languageKey.getKey(), value);
	}
}

@Embeddable
class LanguageKey implements Serializable {
	private String language;

	private String key;

	String getKey() {
		return key;
	}
}

