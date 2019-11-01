package dj.personal.website.translation;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class TranslationDTO {
	private final Map<ApplicationLocale, Map<String, String>> translations;
}
