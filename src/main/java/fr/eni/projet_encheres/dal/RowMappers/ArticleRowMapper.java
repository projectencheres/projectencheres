package fr.eni.projet_encheres.dal.RowMappers;

import fr.eni.projet_encheres.bo.Article;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
    
public class ArticleRowMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        Article article = new Article();

        article.setNoArticle(rs.getInt("no_article"));
        article.setNomArticle(rs.getString("nom_article"));
        article.setDescription(rs.getString("description"));
        article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
        article.setDateFinEncheres(rs.getDate("date_fin_encheres"));
        article.setMiseAPrix(rs.getDouble("mise_a_prix"));
        article.setPrixVente(rs.getDouble("prix_vente"));
        article.setEtatVente(rs.getString("etat_vente"));
        article.setCategorieArticle(rs.getInt("categorie_article"));
        article.setLieuRetrait(rs.getInt("lieu_retrait"));

        return article;
    }
}

