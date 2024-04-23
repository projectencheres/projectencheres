package fr.eni.projet_encheres.dal.RowMappers;

import fr.eni.projet_encheres.bo.Enchere;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnchereRowMapper implements RowMapper<Enchere> {
    @Override
    public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
        Enchere enchere = new Enchere();

        enchere.setNoEnchere(rs.getLong("noenchere"));
        enchere.setDateEnchere(rs.getDate("dateenchere"));
        enchere.setMontantEnchere(rs.getBigDecimal("montant_enchere"));
        enchere.setNoArticle(rs.getLong("noarticle"));
        enchere.setNoUtilisateur(rs.getLong("noutilisateur"));

        return enchere;

    }
}
