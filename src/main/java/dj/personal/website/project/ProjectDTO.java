package dj.personal.website.project;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class ProjectDTO {
	private String icon;
	private String client;
	private String jobTitle;
	private String jobDescription;
	private String timeSpan;
	private Set<String> technologies;
}
