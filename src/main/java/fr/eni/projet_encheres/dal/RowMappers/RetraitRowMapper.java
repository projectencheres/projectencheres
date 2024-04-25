package fr.eni.projet_encheres.dal.RowMappers;

import fr.eni.projet_encheres.bo.Retrait;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RetraitRowMapper implements RowMapper<Retrait> {

    @Override
    public Retrait mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
        Retrait retrait = new Retrait();

        retrait.setNoRetrait(rs.getInt("no_retrait"));
        retrait.setRue(rs.getString("rue"));
        retrait.setCodePostal(rs.getString("code_postal"));
        retrait.setVille(rs.getString("ville"));

        return retrait;
    }
}
