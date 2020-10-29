package dj.personal.website.article;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dj.personal.website.Role;

@RestController()
class ArticleController {
	private final ArticleRepository articleRepository;

	@Autowired
	public ArticleController(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@GetMapping("api/articles")
	@RolesAllowed(Role.ADMIN)
	public Collection<ArticleDTO> findAll() {
		return articleRepository.findAll()
				.stream()
				.map(Article::toDTO)
				.sorted(Comparator.comparing(ArticleDTO::getPublicationDate).reversed())
				.collect(toList());
	}
}
