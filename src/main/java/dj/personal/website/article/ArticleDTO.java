package dj.personal.website.article;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class ArticleDTO {
	private final LocalDate publicationDate;
	private final String url;
	private final String category;
	private final String title;
}
