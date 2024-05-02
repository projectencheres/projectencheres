package fr.eni.projet_encheres.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.projet_encheres.bo.Utilisateur;
import fr.eni.projet_encheres.dal.RowMappers.UtilisateurRowMapper;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private Object jdbTemplate;

    @Autowired
    public UtilisateurRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
    }

    @Override
    public List<Utilisateur> findAll() {
        String sql = "SELECT * FROM utilisateurs";
        return jdbcTemplate.query(sql, new UtilisateurRowMapper());
    }

    @Override
    public Optional<Utilisateur> findById(int _id) {
        String sql = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?";
        Optional<Utilisateur> opt;

        try {
            Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, new UtilisateurRowMapper(), _id);
            opt = Optional.of(utilisateur);
        } catch (Exception e) {
            opt = Optional.empty();
        }
        return opt;
    }

    @SuppressWarnings("null")
    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
                + "VALUES (:pseudo, :nom, :prenom, :email, :telephone, :rue, :code_postal, :ville, :mot_de_passe, :credit, :administrateur)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameters = getMapSqlParameterSource(utilisateur);

        namedParameterJdbcTemplate.update(sql, parameters, keyHolder, new String[] { "no_utilisateur" });
        utilisateur.setNoUtilisateur(keyHolder.getKey().intValue());
        return utilisateur;
    }

    @Override
    public void update(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?  WHERE no_utilisateur = ?";
        jdbcTemplate.update(sql, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(),
                utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getRue(), utilisateur.getCodePostal(),
                utilisateur.getVille(), utilisateur.getNoUtilisateur());
    }

    @Override
    public Optional<Utilisateur> findByPseudoOrEmail(String identifiant) {

        String buildIdentifiant = identifiant.toLowerCase();
        String sql = "SELECT *  from utilisateurs WHERE LOWER(pseudo) = ? OR LOWER(email) = ?";

        List<Utilisateur> utilisateurs = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Utilisateur.class),
                buildIdentifiant,
                buildIdentifiant);

        return utilisateurs.isEmpty() ? Optional.empty() : Optional.ofNullable(utilisateurs.get(0));

    }

    @Override
    public void deleteById(int id) {

        String deleteEncheresSql = "DELETE FROM encheres WHERE no_utilisateur = ?";
        jdbcTemplate.update(deleteEncheresSql, id);

        String sql = "DELETE FROM utilisateurs WHERE no_utilisateur = ?";
        jdbcTemplate.update(sql, id);
    }
    
    
    public Utilisateur findByPseudo(String pseudo) {
    	String sql = "SELECT * FROM utilisateurs WHERE pseudo = ?";
        return this.jdbcTemplate.queryForObject(sql, new UtilisateurRowMapper());

    }

    private static MapSqlParameterSource getMapSqlParameterSource(Utilisateur utilisateur) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("pseudo", utilisateur.getPseudo());
        parameters.addValue("nom", utilisateur.getNom());
        parameters.addValue("prenom", utilisateur.getPrenom());
        parameters.addValue("email", utilisateur.getEmail());
        parameters.addValue("telephone", utilisateur.getTelephone());
        parameters.addValue("rue", utilisateur.getRue());
        parameters.addValue("code_postal", utilisateur.getCodePostal());
        parameters.addValue("ville", utilisateur.getVille());
        parameters.addValue("mot_de_passe", utilisateur.getMotDePasse());
        parameters.addValue("credit", utilisateur.getCredit());
        parameters.addValue("administrateur", utilisateur.getAdministrateur());
        return parameters;
    }
}
