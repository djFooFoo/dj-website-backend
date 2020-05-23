package dj.personal.website.book;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonDeserialize(builder = BookDto.BookDtoBuilder.class)
class BookDto {
	private final Long isbn;
	private final String authors;
	private final Integer yearRead;
	private final String title;

	@JsonPOJOBuilder(withPrefix = "")
	public static class BookDtoBuilder {

	}
}
