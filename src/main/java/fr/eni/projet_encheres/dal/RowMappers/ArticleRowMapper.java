package fr.eni.projet_encheres.dal.RowMappers;

import fr.eni.projet_encheres.bo.Article;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
    
public class ArticleRowMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        Article article = new Article();

        article.setNoArticle(rs.getInt("noArticle"));
        article.setNomArticle(rs.getString("nomArticle"));
        article.setDescription(rs.getString("description"));
        article.setDateDebutEncheres(rs.getDate("dateDebutEncheres"));
        article.setDateFinEncheres(rs.getDate("dateFinEncheres"));
        article.setMiseAPrix(rs.getDouble("miseAPrix"));
        article.setPrixVente(rs.getDouble("prixVente"));
        article.setEtatVente(rs.getString("etatVente"));
        article.setCategorieArticle(rs.getInt("categorieArticle"));
        article.setLieuRetrait(rs.getInt("lieuRetrait"));

        return article;
    }
}

