package dj.personal.website.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
class Book {
	@Id
	private Long isbn;

	private String title;

	private String authors;

	private int yearRead;

	private Float rating;
}
