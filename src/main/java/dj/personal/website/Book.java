package dj.personal.website;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private int yearRead;

	BookDTO toDTO() {
		return BookDTO.builder()
				.yearRead(yearRead)
				.title(title)
				.build();
	}
}
