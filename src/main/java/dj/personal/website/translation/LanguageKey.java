package dj.personal.website.translation;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.*;

/**
 * @author dj
 */
@Embeddable
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class LanguageKey implements Serializable {
	private String language;
	private String key;
}
