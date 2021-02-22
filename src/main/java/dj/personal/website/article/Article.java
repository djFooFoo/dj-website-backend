package dj.personal.website.article;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Column(columnDefinition = "DATE")
	private LocalDate publicationDate;

	private String url;

	private String category;

	private String introduction;
}
