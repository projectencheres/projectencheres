package fr.eni.projet_encheres.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.projet_encheres.bo.Utilisateur;

public class UtilisateurRepositoryImpl {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Utilisateur> findAll() {
        String sql = "SELECT * FROM Utilisateur";
        return jdbcTemplate.query(sql, new UtilisateurRowMapper());
    }

    @Override
    public Optional<Utilisateur> findById(int _id) {
        String sql = "SELECT * FROM Utilisateur WHERE noUtilisateur = ?";
        Optional<Utilisateur> opt;

        try {
            Utilisateur Utilisateur = jdbcTemplate.queryForObject(sql, new UtilisateurRowMapper(), _id);
            opt = Optional.of(Utilisateur);
        } catch (Exception e) {
            opt = Optional.empty();
        }
        return opt;
    }

    @Override
    public void save(Utilisateur Utilisateur) {
        String sql = "INSERT INTO Utilisateur (nomUtilisateur, description, dateDebutEncheres, dateFinEncheres, miseAPrix, categorieUtilisateur, lieuRetrait) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, Utilisateur.getNomUtilisateur(), Utilisateur.getDescription(), Utilisateur.getDateDebutEncheres(),
            Utilisateur.getDateFinEncheres(), Utilisateur.getMiseAPrix(), Utilisateur.getCategorieUtilisateur(), Utilisateur.getLieuRetrait());
    }

    @Override
    public void update(Utilisateur Utilisateur) {
        String sql = "UPDATE Utilisateur SET nomUtilisateur = ?, description = ?, dateDebutEncheres = ?, dateFinEncheres = ?, miseAPrix = ?, prixVente = ?, etatVente = ?, categorieUtilisateur = ?, lieuRetrait = ? WHERE noUtilisateur = ?";
        jdbcTemplate.update(sql, Utilisateur.getNomUtilisateur(), Utilisateur.getDescription(), Utilisateur.getDateDebutEncheres(), Utilisateur.getDateFinEncheres(),
            Utilisateur.getMiseAPrix(), Utilisateur.getPrixVente(), Utilisateur.getEtatVente(), Utilisateur.getCategorieUtilisateur(), Utilisateur.getLieuRetrait(), Utilisateur.getNoUtilisateur());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM Utilisateur WHERE noUtilisateur = ?";
        jdbcTemplate.update(sql, id);
    }
}
