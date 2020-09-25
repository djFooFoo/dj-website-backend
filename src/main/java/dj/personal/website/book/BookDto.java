package dj.personal.website.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BookDto {
	private final Long isbn;
	private final String authors;
	private final Integer yearRead;
	private final String title;
	private final Float rating;
}
