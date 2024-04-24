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
        String sql = " SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur from encheres";

        return jdbcTemplate.query(sql, new EnchereRowMapper());
    }

    @Override
    public Enchere findById(int noEnchere) {
        String sql = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM encheres WHERE no_enchere = ?";

        return jdbcTemplate.queryForObject(sql, new EnchereRowMapper(), noEnchere);
    }
}
