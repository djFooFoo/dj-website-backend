package dj.personal.website.project;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dj.personal.website.Role;

@RestController()
class ProjectController {
	private final ProjectRepository projectRepository;

	@Autowired
	public ProjectController(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@GetMapping("api/project")
	@RolesAllowed(Role.ADMIN)
	public Collection<ProjectDTO> findAll() {
		return projectRepository.findAll()
				.stream()
				.sorted(Collections.reverseOrder())
				.map(Project::toDTO)
				.collect(toList());
	}
}

