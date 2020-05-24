package dj.personal.website.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Book {
	@Id
	private Long isbn;

	@Column(unique=true)
	private String title;

	private String authors;

	private int yearRead;

	BookDto toDTO() {
		return BookDto.builder()
				.isbn(isbn)
				.title(title)
				.authors(authors)
				.yearRead(yearRead)
				.build();
	}
}
