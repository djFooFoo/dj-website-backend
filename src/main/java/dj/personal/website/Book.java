package dj.personal.website;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Book implements Comparable<Book> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private int yearRead;

	@Override
	public int compareTo(Book book) {
		if (yearRead != book.yearRead) {
			return Integer.compare(book.yearRead, yearRead);
		}
		return title.compareTo(book.title);
	}

	BookDTO toDTO() {
		return BookDTO.builder()
				.yearRead(yearRead)
				.title(title)
				.build();
	}
}
