package dj.personal.website;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Book {
	@Id
	private Long isbn;

	private String title;

	private String authors;

	private int yearRead;

	BookDTO toDTO() {
		return BookDTO.builder()
				.isbn(isbn)
				.title(title)
				.authors(authors)
				.yearRead(yearRead)
				.build();
	}
}
