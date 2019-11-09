package dj.personal.website.blogpost;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Blogpost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Column(columnDefinition = "DATE")
	private LocalDate publicationDate;

	private String url;

	private String category;

	BlogpostDTO toDTO() {
		return BlogpostDTO.builder()
				.title(title)
				.publicationDate(publicationDate)
				.url(url)
				.category(category)
				.build();
	}
}
