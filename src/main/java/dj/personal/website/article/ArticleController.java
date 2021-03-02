package dj.personal.website.article;

import dj.personal.website.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/articles")
class ArticleController {
	private final ArticleService articleService;

	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(Role.ADMIN)
	public Collection<Article> findAll() {
		return articleService.findAll();
	}

	@PutMapping
	@RolesAllowed(Role.ADMIN)
	public Article save(@RequestBody Article article) {
		return articleService.save(article);
	}
}
