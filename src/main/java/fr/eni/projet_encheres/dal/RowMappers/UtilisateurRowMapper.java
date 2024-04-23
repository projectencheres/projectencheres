package fr.eni.projet_encheres.dal.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.eni.projet_encheres.bo.Enchere;
import fr.eni.projet_encheres.bo.Utilisateur;

public class UtilisateurRowMapper implements RowMapper<Utilisateur> {
    @Override
    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
        utilisateur.setPseudo(rs.getString("pseudo"));
        utilisateur.setNom(rs.getString("nom"));
        utilisateur.setPrenom(rs.getString("prenom"));
        utilisateur.setEmail(rs.getString("email"));
        utilisateur.setTelephone(rs.getString("telephone"));
        utilisateur.setRue(rs.getString("rue"));
        utilisateur.setCodePostal(rs.getString("code_postal"));
        utilisateur.setVille(rs.getString("ville"));
        utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
        utilisateur.setCredit(rs.getDouble("credit"));
        utilisateur.setAdministrateur(rs.getBoolean("administrateur"));

        return utilisateur;

    }
}
