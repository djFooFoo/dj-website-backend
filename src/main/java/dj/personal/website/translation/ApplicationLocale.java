package dj.personal.website.translation;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author dj
 */

public enum ApplicationLocale {
	EN(Locale.ENGLISH),
	NL(new Locale("nl")),
	FR(Locale.FRENCH);

	private final Locale locale;

	ApplicationLocale(Locale locale) {
		this.locale = locale;
	}

	private static Optional<ApplicationLocale> findLocaleByValue(String value) {
		return Arrays.stream(ApplicationLocale.values())
				.filter(locale -> locale.name().toLowerCase().equals(value))
				.findFirst();
	}

	@JsonValue
	public String toValue() {
		return this.name().toLowerCase();
	}

	public Locale toLocale() {
		return this.locale;
	}

	public static boolean isLocaleSupported(String locale) {
		return findLocaleByValue(locale).isPresent();
	}

	public static ApplicationLocale getDefaultLocale() {
		return EN;
	}
}
