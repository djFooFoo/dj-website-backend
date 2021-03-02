package dj.personal.website.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;

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

    public Article save(Article article) {
        return articleRepository.save(article);
    }
}
