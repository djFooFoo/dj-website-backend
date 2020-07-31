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
	private String base64image;
	private final Float rating;
}
