package dj.personal.website.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Collection<Article> findAll() {
        return articleRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Article::getPublicationDate).reversed())
                .collect(toList());
    }

    public Article saveIfNotExists(Article article) {
        return articleRepository.findByUrl(article.getUrl())
                .orElseGet(() -> articleRepository.save(article));
    }

    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }
}
