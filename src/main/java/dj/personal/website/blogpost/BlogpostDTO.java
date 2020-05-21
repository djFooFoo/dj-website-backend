package dj.personal.website.blogpost;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BlogpostDTO {
	private final LocalDate publicationDate;
	private final String url;
	private final String category;
	private final String title;
}
