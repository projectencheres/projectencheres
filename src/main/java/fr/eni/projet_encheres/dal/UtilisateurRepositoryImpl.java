package fr.eni.projet_encheres.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.projet_encheres.bo.Utilisateur;
import fr.eni.projet_encheres.dal.RowMappers.UtilisateurRowMapper;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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

    @Override
    public void save(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
        jdbcTemplate.update(sql, utilisateur.getNoUtilisateur(), utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), 
        utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille(), utilisateur.getMotDePasse(), utilisateur.getCredit(), utilisateur.getAdministrateur());
    }

    @Override
    public void update(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateurs SET no_utilisateur = ?, pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ?  WHERE no_utilisateur = ?";
        jdbcTemplate.update(sql, utilisateur.getNoUtilisateur(), utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(),
        utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille(), utilisateur.getMotDePasse(), utilisateur.getCredit(), utilisateur.getAdministrateur());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM utilisateurs WHERE no_utilisateur = ?";
        jdbcTemplate.update(sql, id);
    }
}
