package fr.eni.projet_encheres.dal.RowMappers;

import fr.eni.projet_encheres.bo.Article;
import fr.eni.projet_encheres.bo.Enchere;

import fr.eni.projet_encheres.bo.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnchereRowMapper implements RowMapper<Enchere> {
    @Override
    public Enchere mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
        Enchere enchere = new Enchere();

        enchere.setNoEnchere(rs.getInt("no_enchere"));
        enchere.setDateEnchere(rs.getDate("date_enchere"));
        enchere.setMontantEnchere(rs.getDouble("montant_enchere"));

        Article article = new Article(
                rs.getInt("no_article"),
                rs.getString("nom_article"),
                rs.getDate("date_fin_encheres"),
                rs.getDouble("prix_vente"),
                rs.getInt("categorie_article")
        );

        enchere.setArticle(article);

        Utilisateur utilisateur = new Utilisateur(
                // rs.getInt("no_utilisateur"),
                // rs.getString("pseudo"),
                // rs.getString("nom"),
                // rs.getString("prenom"),
                // rs.getString("email"),
                // rs.getString("telephone"),
                // rs.getString("rue"),
                // rs.getString("code_postal"),
                // rs.getString("ville"),
                // rs.getString("mot_de_passe"),
                // rs.getDouble("credit"),
                // rs.getBoolean("administrateur")
        );

        enchere.setUtilisateur(utilisateur);

        return enchere;

    }
}
