package dj.personal.website.blogpost;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BlogpostDTO {
	private final String title;
	private final LocalDate publicationDate;
	private final String url;
}
