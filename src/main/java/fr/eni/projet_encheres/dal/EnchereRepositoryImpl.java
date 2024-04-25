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
        String sql = "SELECT e.*, a.*, u.* FROM encheres e"
                + " INNER JOIN articles a on e.no_article = a.no_article"
                + " INNER JOIN utilisateurs u on e.no_utilisateur = u.no_utilisateur";

        return jdbcTemplate.query(sql, new EnchereRowMapper());
    }

    @Override
    public Enchere findById(int noEnchere) {
        String sql = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM encheres WHERE no_enchere = ?";

        return jdbcTemplate.queryForObject(sql, new EnchereRowMapper(), noEnchere);
    }

    @Override
    public List<Enchere> findByName(String _name) {
        String build = '%'+_name+'%';
        System.out.println(build);
        String sql = "SELECT e.no_enchere, e.date_enchere, e.montant_enchere, e.no_article, a.*"
        +" FROM encheres e"
        +" LEFT JOIN articles a ON e.no_article = a.no_article"
        +" WHERE LOWER(a.nom_article) LIKE ?";
        return jdbcTemplate.query(sql, new EnchereRowMapper(), build);
    }

    @override
    public List<Enchere> findByCategorie() {
        String sql = "";
        return jdbcTemplate.query(sql, new EnchereRowMapper());
    }

    @override
    public List<Enchere> findByNameAndCategorie() {
        String sql = "";
        return jdbcTemplate.query(sql, new EnchereRowMapper());
    }
}
