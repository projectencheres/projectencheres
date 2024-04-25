package fr.eni.projet_encheres.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String sql = "SELECT * FROM articles";
        return jdbcTemplate.query(sql, new ArticleRowMapper());
    }

    @Override
    public Optional<Article> findById(int _id) {
        String sql = "SELECT * FROM articles WHERE no_article = ?";
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
        String sql = "INSERT INTO articles (no_article, nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, prix_vente, etat_vente, categorie_article, lieu_retrait) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, article.getNoArticle(), article.getNomArticle(), article.getDescription(), article.getDateDebutEncheres(),
            article.getDateFinEncheres(), article.getMiseAPrix(), article.getPrixVente(), article.getEtatVente(), article.getCategorieArticle(), article.getLieuRetrait());
    }

    @Override
    public void update(Article article) {
        String sql = "UPDATE articles SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, mise_a_prix = ?, prix_vente = ?, etat_vente = ?, categorie_article = ?, lieu_retrait = ? WHERE no_article = ?";
        jdbcTemplate.update(sql, article.getNomArticle(), article.getDescription(), article.getDateDebutEncheres(), article.getDateFinEncheres(),
            article.getMiseAPrix(), article.getPrixVente(), article.getEtatVente(), article.getCategorieArticle(), article.getLieuRetrait(), article.getNoArticle());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM articles WHERE no_article = ?";
        jdbcTemplate.update(sql, id);
    }
}
