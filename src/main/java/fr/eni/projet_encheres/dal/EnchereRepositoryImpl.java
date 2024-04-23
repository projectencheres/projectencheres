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
        String sql = " SELECT e.no_enchere, e.date_enchere, e.montant_enchere, a.no_article, u.no_utilisateur "
                + " from encheres e "
                + " inner join articles a on a.no_article = e.no_article "
                + " inner join utilisateurs u on u.no_utilisateur = e.no_utilisateur";

        return jdbcTemplate.query(sql, new EnchereRowMapper());
    }
}
