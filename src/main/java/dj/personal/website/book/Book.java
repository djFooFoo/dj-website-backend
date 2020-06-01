package dj.personal.website.book;

import javax.persistence.Column;
import javax.persistence.Entity;
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
class Book {
	@Id
	private Long isbn;

	@Column(unique = true)
	private String title;

	private String authors;

	private int yearRead;

	@Lob
	private String base64image;

	BookDto toDTO() {
		return BookDto.builder()
				.isbn(isbn)
				.title(title)
				.authors(authors)
				.yearRead(yearRead)
				.base64image(base64image)
				.build();
	}
}
