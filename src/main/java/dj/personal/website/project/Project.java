package dj.personal.website.project;

import static java.util.stream.Collectors.toSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
class Project implements Comparable<Project> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String icon;
	private String client;
	private String jobTitle;
	private String jobDescription;
	private String timeSpan;

	@OneToMany(mappedBy = "project")
	@Fetch(FetchMode.JOIN)
	private Set<Technology> technologySet;

	ProjectDTO toDTO() {
		return ProjectDTO.builder()
				.icon(icon)
				.client(client)
				.jobTitle(jobTitle)
				.jobDescription(jobDescription)
				.timeSpan(timeSpan)
				.technologies(getTechnologyNames())
				.build();
	}

	private Set<String> getTechnologyNames() {
		return technologySet.stream()
				.map(Technology::getName)
				.collect(toSet());
	}

	@Override
	public int compareTo(Project project) {
		return this.id.compareTo(project.id);
	}
}
