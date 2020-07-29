package dj.personal.website.project;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dj
 */
@Order(1)
@Component
@Slf4j
public class ProjectRunner implements CommandLineRunner {
	private final ProjectRepository projectRepository;
	private final TechnologyRepository technologyRepository;

	@Autowired
	public ProjectRunner(ProjectRepository projectRepository, TechnologyRepository technologyRepository) {
		this.projectRepository = projectRepository;
		this.technologyRepository = technologyRepository;
	}

	@Override
	public void run(String... args) {
		Collection<Project> projects = createProjects();

		int size = projects.size();
		log.info(size + " projects have been saved to the database.");

		Collection<Technology> technologies = technologyRepository.findAll();
		size = technologies.size();
		log.info(size + " technologies have been saved to the database.");
	}

	private Collection<Project> createProjects() {
		Set<String> fodTechnologyNames = Stream
				.of(
						"Java 8", "Spring", "Angular", "Jasmine", "CouchDB",
						"ElasticSearch", "Mockito", "JUnit", "Nginx",
						"REST Assured", "AssertJ", "Intellij", "Jira", "Git",
						"Scrum/Agile", "Keycloak", "Docker", "TypeScript", "Swagger",
						"Cypress", "Node", "SCSS"
				)
				.collect(toSet());
		createAndSaveProject("fa-file", "fod.justice", "Full-Stack Developer", "fod.justice.description", "fod.justice.time.span", fodTechnologyNames);

		Set<String> ravagoTechnologyNames = Stream
				.of(
						"Java 6", "Spring", "Selenium", "JBoss", "Mockito",
						"SQL", "Intellij", "Confluence", "Jira", "Git", "Bamboo",
						"JSP", "Scrum/Agile", "Jenkins", "Docker", "Perl"
				)
				.collect(toSet());
		createAndSaveProject("fa-tree", "Ravago", "Java Developer", "ravago.description", "ravago.time.span", ravagoTechnologyNames);

		Set<String> boseTechnologyNames = Stream
				.of(
						"Java 8", "Javascript", "SCSS", "Groovy", "Html5",
						"AEM", "Bamboo", "Mockito", "PowerMock", "Hybris",
						"Spring", "Intellij", "Scrum/Agile", "jQuery"
				)
				.collect(toSet());
		createAndSaveProject("fa-headphones", "Bose", "Java Developer", "bose.description", "bose.time.span", boseTechnologyNames);

		return projectRepository.findAll();
	}

	private void createAndSaveProject(String icon, String client, String jobTitle, String jobDescription, String timeSpan, Set<String> technologyNames) {
		Project project = Project.builder()
				.icon(icon)
				.client(client)
				.jobTitle(jobTitle)
				.jobDescription(jobDescription)
				.timeSpan(timeSpan)
				.build();

		Project savedProject = projectRepository.save(project);

		Set<Technology> technologies = technologyNames.stream()
				.map(name -> Technology.builder().name(name).project(savedProject).build())
				.collect(toSet());

		technologyRepository.saveAll(technologies);
	}
}
