package dj.personal.website.blogpost;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
class Blogpost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Column(columnDefinition = "DATE")
	private LocalDate publicationDate;

	private String url;

	private String category;

	@Lob
	private String base64image;

	BlogpostDTO toDTO() {
		return BlogpostDTO.builder()
				.title(title)
				.publicationDate(publicationDate)
				.url(url)
				.category(category)
				.base64image(base64image)
				.build();
	}
}
