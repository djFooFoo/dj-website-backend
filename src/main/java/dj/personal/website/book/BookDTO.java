package dj.personal.website.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BookDTO {
	private final Long isbn;
	private final String title;
	private final String authors;
	private final Integer yearRead;
}
