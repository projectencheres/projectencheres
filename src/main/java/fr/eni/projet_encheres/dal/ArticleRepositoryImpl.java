package fr.eni.projet_encheres.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.projet_encheres.bo.Article;
import fr.eni.projet_encheres.dal.RowMappers.ArticleRowMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Article> findAll() {
        String sql = "SELECT * FROM Article";
        return jdbcTemplate.query(sql, new ArticleRowMapper());
    }

    @Override
    public Optional<Article> findById(int _id) {
        String sql = "SELECT * FROM Article WHERE noArticle = ?";
        Optional<Article> opt;

        try {
            Article article = jdbcTemplate.queryForObject(sql, new ArticleRowMapper(), _id);
            opt = Optional.of(article);
        } catch (Exception e) {
            opt = Optional.empty();
        }
        return opt;
    }

    @Override
    public void save(Article article) {
        String sql = "INSERT INTO Article (nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, categorieArticle, lieuRetrait) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, article.getNomArticle(), article.getDescription(), article.getDateDebutEncheres(),
            article.getDateFinEncheres(), article.getMiseAPrix(), article.getCategorieArticle(), article.getLieuRetrait());
    }

    @Override
    public void update(Article article) {
        String sql = "UPDATE Article SET nomArticle = ?, description = ?, dateDebutEncheres = ?, dateFinEncheres = ?, miseAPrix = ?, prixVente = ?, etatVente = ?, categorieArticle = ?, lieuRetrait = ? WHERE noArticle = ?";
        jdbcTemplate.update(sql, article.getNomArticle(), article.getDescription(), article.getDateDebutEncheres(), article.getDateFinEncheres(),
            article.getMiseAPrix(), article.getPrixVente(), article.getEtatVente(), article.getCategorieArticle(), article.getLieuRetrait(), article.getNoArticle());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM Article WHERE noArticle = ?";
        jdbcTemplate.update(sql, id);
    }
}
