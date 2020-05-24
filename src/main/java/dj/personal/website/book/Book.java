package dj.personal.website.book;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder()
@NoArgsConstructor
@AllArgsConstructor
class Book {
	@Id
	private Long isbn;

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
