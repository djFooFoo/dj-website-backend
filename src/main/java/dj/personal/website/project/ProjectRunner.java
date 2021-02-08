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
	private final ResponsibilityRepository responsibilityRepository;

	@Autowired
	public ProjectRunner(ProjectRepository projectRepository,
						 TechnologyRepository technologyRepository,
						 ResponsibilityRepository responsibilityRepository) {
		this.projectRepository = projectRepository;
		this.technologyRepository = technologyRepository;
		this.responsibilityRepository = responsibilityRepository;
	}

	@Override
	public void run(String... args) {
		Collection<Project> projects = createProjects();

		log.info(projects.size() + " projects have been saved to the database.");

		Collection<Technology> technologies = technologyRepository.findAll();
		log.info(technologies.size() + " technologies have been saved to the database.");

		Collection<Responsibility> responsibilities = responsibilityRepository.findAll();
		log.info(responsibilities.size() + " responsibilities have been saved to the database.");
	}

	private Collection<Project> createProjects() {
		Project boseProject = createAndSaveProject("fa-headphones", "Bose", "Java Developer", "October 2016 - March 2017");
		createAndSaveTechnologies(asSet("Java 8", "Javascript", "SCSS", "Groovy", "Html5", "AEM", "Bamboo",
				"Mockito", "PowerMock", "Hybris", "Spring", "Intellij", "Scrum/Agile", "jQuery"),
				boseProject);
		createAndSaveResponsibilities(asSet(
				"Development of a worldwide used B2B Consumer Portal"
				),
				boseProject);

		Project ravagoProject = createAndSaveProject("fa-tree", "Ravago", "Java Developer", "May 2017 - August 2018");
		createAndSaveTechnologies(
				asSet("Java 6", "Spring", "Selenium", "JBoss", "Mockito", "SQL", "Intellij",
						"Confluence", "Jira", "Git", "Bamboo", "JSP", "Scrum/Agile", "Jenkins", "Docker", "Perl"), ravagoProject);
		createAndSaveResponsibilities(asSet(
				"Development of a custom ERP tool used within the worldwide Ravago Group",
				"Contributed to the project of maintaining an old code base and migrating it to a new high-performance environment",
				"Deploying applications across teams",
				"Aiding the transformation of a manual testing strategy to an automated testing strategy",
				"Leading when this was requested (squad lead, substitute scrum master)",
				"Performed complex queries on the production database to correct data on request"
				),
				ravagoProject);

		Project smalsProject = createAndSaveProject("fa-file", "Smals", "Leading Developer", "September 2018 - present");
		createAndSaveTechnologies(
				asSet("Java 8", "Spring", "Angular", "Jasmine", "CouchDB", "ElasticSearch",
						"Mockito", "JUnit", "Nginx", "REST Assured", "AssertJ", "Intellij", "Jira", "Git", "Scrum/Agile",
						"Keycloak", "Docker", "TypeScript", "Swagger", "Cypress", "Node", "SCSS", "KeyLines", "Jenkins"), smalsProject);
		createAndSaveResponsibilities(asSet(
				"This project is subject to confidentiality"), smalsProject);

		return projectRepository.findAll();
	}

	private Set<String> asSet(String... arguments) {
		return Stream.of(arguments).collect(toSet());
	}

	private Project createAndSaveProject(String icon, String client, String jobTitle, String timeSpan) {
		Project project = Project.builder()
				.icon(icon)
				.client(client)
				.jobTitle(jobTitle)
				.timeSpan(timeSpan)
				.build();

		return projectRepository.save(project);
	}

	private void createAndSaveTechnologies(Set<String> technologyNames, Project savedProject) {
		Set<Technology> technologies = technologyNames.stream()
				.map(name -> Technology.builder().name(name).project(savedProject).build())
				.collect(toSet());

		technologyRepository.saveAll(technologies);
	}

	private void createAndSaveResponsibilities(Set<String> responsibilityNames, Project savedProject) {
		Set<Responsibility> responsibilities = responsibilityNames.stream()
				.map(name -> Responsibility.builder().name(name).project(savedProject).build())
				.collect(toSet());

		responsibilityRepository.saveAll(responsibilities);
	}
}
