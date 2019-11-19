package dj.personal.website.translation;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author dj
 */

public enum ApplicationLocale {
	EN,
	NL,
	FR;

	@JsonValue
	public String toValue() {
		return this.name().toLowerCase();
	}
}
