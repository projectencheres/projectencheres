package fr.eni.projet_encheres.bll;

import java.util.List;

import fr.eni.projet_encheres.bo.Article;
import fr.eni.projet_encheres.exceptions.ArticleNotFound;

public interface ArticleService {

    List<Article> findAll();

    Article findById(int noArticle) throws ArticleNotFound;

    void save(Article Article);

    void update(Article Article);

    void delete(int _id);
}
