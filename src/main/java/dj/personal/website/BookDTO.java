package dj.personal.website;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BookDTO {
	private final Integer yearRead;
	private final String title;
}
