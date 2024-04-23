package fr.eni.projet_encheres.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.projet_encheres.bo.Article;

public interface ArticleRepository {
    List<Article> findAll();
    Optional<Article> findById(int id);
    void save(Article article);
    void update(Article article);
    void deleteById(int id);
}
