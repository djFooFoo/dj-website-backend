package dj.personal.website.article;

import dj.personal.website.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

@RestController()
class ArticleController {
	private final ArticleService articleService;

	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("api/articles")
	@RolesAllowed(Role.ADMIN)
	public Collection<Article> findAll() {
		return articleService.findAll();
	}

	@PutMapping("api/articles")
	@RolesAllowed(Role.ADMIN)
	public Article save(Article article) {
		return articleService.save(article);
	}
}
