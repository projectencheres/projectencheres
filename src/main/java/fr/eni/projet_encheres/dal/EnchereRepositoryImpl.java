package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Enchere;
import fr.eni.projet_encheres.dal.RowMappers.EnchereRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String build = '%' + _name.toLowerCase() + '%';
        System.out.println(build);
        String sql = "SELECT e.no_enchere, e.date_enchere, e.montant_enchere, e.no_article, a.*, u.*"
        +" FROM encheres e"
        +" INNER JOIN articles a ON e.no_article = a.no_article"
        +" INNER JOIN utilisateurs u on e.no_utilisateur = u.no_utilisateur"
        +" WHERE LOWER(a.nom_article) LIKE ?";
        return jdbcTemplate.query(sql, new EnchereRowMapper(), build);
    }

    @override
    public List<Enchere> findByCategorie(int noCategorie) {
        String sql = "SELECT e.no_enchere, e.date_enchere, e.montant_enchere, e.no_article, e.no_utilisateur, a.*, u.* "
            +" FROM encheres e"
            +" INNER JOIN articles a ON e.no_article = a.no_article"
            +" INNER JOIN categories c ON c.no_categorie = a.categorie_article"
            +" INNER JOIN utilisateurs u on e.no_utilisateur = u.no_utilisateur"
            +" WHERE c.no_categorie = ?";
        return jdbcTemplate.query(sql, new EnchereRowMapper(), noCategorie);
    }

    @override
    public List<Enchere> findByNameAndCategorie(String _name, int noCategorie) {
        String build = '%' + _name.toLowerCase() + '%';
        String sql = "SELECT e.no_enchere, e.date_enchere, e.montant_enchere, e.no_article, e.no_utilisateur, a.*, u.*"
            +" FROM encheres e"
            +" INNER JOIN articles a ON e.no_article = a.no_article"
            +" INNER JOIN categories c ON c.no_categorie = a.categorie_article"
            +" INNER JOIN utilisateurs u on e.no_utilisateur = u.no_utilisateur"
            +" WHERE LOWER(a.nom_article) LIKE ? AND c.no_categorie = ?";
        return jdbcTemplate.query(sql, new EnchereRowMapper(), build, noCategorie);
    }

    @Override
    public Map<String, Object> customFindById(int noEnchere, String sessionUserIdentifiant) {
        String sql = "SELECT e.no_enchere, max_montant.montant_enchere, a.no_article, a.nom_article, a.description, a.date_fin_encheres, a.mise_a_prix,"
                + " r.rue, r.code_postal, r.ville, c.libelle, u.pseudo, "
                + " (SELECT credit FROM utilisateurs WHERE pseudo = ? OR email = ?) AS session_user_credit"
                + " FROM encheres e"
                + " LEFT JOIN articles a ON e.no_article = a.no_article"
                + " LEFT JOIN retraits r ON r.no_retrait = a.lieu_retrait"
                + " INNER JOIN categories c ON c.no_categorie = a.categorie_article"
                + " INNER JOIN utilisateurs u ON e.no_utilisateur = u.no_utilisateur"
                + " INNER JOIN (SELECT no_enchere, MAX(montant_enchere) AS montant_enchere FROM encheres GROUP BY no_enchere)"
                + " max_montant ON e.no_enchere = max_montant.no_enchere"
                + " WHERE e.no_enchere = ?";

        return jdbcTemplate.query(
                sql,
                rs -> {Map<String, Object> dataMap = new HashMap<>();
                    if (rs.next()) {
                        dataMap.put("no_enchere", rs.getInt("no_enchere"));
                        dataMap.put("montant_enchere", rs.getDouble("montant_enchere"));
                        dataMap.put("no_article", rs.getInt("no_article"));
                        dataMap.put("nom_article", rs.getString("nom_article"));
                        dataMap.put("description", rs.getString("description"));
                        dataMap.put("date_fin_encheres", rs.getDate("date_fin_encheres"));
                        dataMap.put("mise_a_prix", rs.getDouble("mise_a_prix"));
                        dataMap.put("rue", rs.getString("rue"));
                        dataMap.put("code_postal", rs.getString("code_postal"));
                        dataMap.put("ville", rs.getString("ville"));
                        dataMap.put("libelle", rs.getString("libelle"));
                        dataMap.put("pseudo", rs.getString("pseudo"));
                        dataMap.put("session_user_credit", rs.getDouble("session_user_credit"));
                    }
                    return dataMap;
                },
                sessionUserIdentifiant,
                sessionUserIdentifiant,
                noEnchere

        );
    }
}
