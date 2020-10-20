package dj.personal.website.translation;

import java.util.AbstractMap;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.*;

/**
 * @author dj
 */
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TranslatedValue {
	@EmbeddedId
	private LanguageKey languageKey;

	@Column(columnDefinition = "TEXT")
	private String value;

	AbstractMap.SimpleEntry<String, String> createKeyAndValuePair() {
		return new AbstractMap.SimpleEntry<>(languageKey.getKey(), value);
	}
}

