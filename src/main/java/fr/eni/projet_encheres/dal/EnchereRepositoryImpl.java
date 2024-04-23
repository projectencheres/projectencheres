package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Enchere;
import fr.eni.projet_encheres.dal.RowMappers.EnchereRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnchereRepositoryImpl implements EnchereRepository {

    private JdbcTemplate jdbcTemplate;

    public EnchereRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Enchere> findAllEncheres() {
        String sql = " SELECT noenchere, dateenchere, montant_enchere, noarticle, noutilisateur, "
                + " from enchere e inner join article a "
                + " on a.noarticle = e.noarticle "
                + " inner join utilisateur u "
                + " on u.noutilisateur = e.noutilisateur ";

        List<Enchere> encheres = jdbcTemplate.query(sql, new EnchereRowMapper());
        return encheres;
    }
}
