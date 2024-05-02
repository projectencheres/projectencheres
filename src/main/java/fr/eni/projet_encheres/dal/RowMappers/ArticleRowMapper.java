package fr.eni.projet_encheres.dal.RowMappers;

import fr.eni.projet_encheres.bo.Article;
import fr.eni.projet_encheres.bo.Retrait;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
        Article article = new Article();
        Retrait retrait = new Retrait();

        // --- init Retrait --- //
        retrait.setRue(rs.getString("rue"));
        retrait.setCodePostal(rs.getString("code_postal"));
        retrait.setVille(rs.getString("ville"));

        // --- init Article --- //
        article.setNoArticle(rs.getInt("no_article"));
        article.setNomArticle(rs.getString("nom_article"));
        article.setDescription(rs.getString("description"));
        article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
        article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
        article.setMiseAPrix(rs.getDouble("mise_a_prix"));
        article.setPrixVente(rs.getDouble("prix_vente"));
        article.setEtatVente(rs.getString("etat_vente"));
        article.setCategorieArticle(rs.getInt("categorie_article"));
        article.setRetrait(retrait);

        return article;
    }
}
