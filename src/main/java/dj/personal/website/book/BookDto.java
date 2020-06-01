package dj.personal.website.book;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = BookDto.BookDtoBuilder.class)
class BookDto {
	private final Long isbn;
	private final String authors;
	private final Integer yearRead;
	private final String title;
	private final String base64image;
	private final Float rating;

	@JsonPOJOBuilder(withPrefix = "")
	public static class BookDtoBuilder {

	}
}
