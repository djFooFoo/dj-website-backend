package dj.personal.website.blogpost;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dj.personal.website.Role;

@RestController()
class BlogpostController {
	private final BlogpostRepository blogpostRepository;

	@Autowired
	public BlogpostController(BlogpostRepository blogpostRepository) {
		this.blogpostRepository = blogpostRepository;
	}

	@GetMapping("api/blogpost")
	@RolesAllowed(Role.ADMIN)
	public Collection<BlogpostDTO> findAll() {
		return blogpostRepository.findAll()
				.stream()
				.map(Blogpost::toDTO)
				.sorted(Comparator.comparing(BlogpostDTO::getPublicationDate).reversed())
				.collect(toList());
	}
}
