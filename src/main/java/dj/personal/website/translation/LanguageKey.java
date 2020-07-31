package dj.personal.website.translation;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author dj
 */
@Embeddable
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LanguageKey implements Serializable {
	private String language;
	private String key;
}
