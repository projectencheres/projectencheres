package fr.eni.projet_encheres.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.projet_encheres.bo.Utilisateur;

public interface UtilisateurRepository {

    List<Utilisateur > findAll();
    Optional<Utilisateur> findById(int id);
    Utilisateur save(Utilisateur Utilisateur);
    void update(Utilisateur Utilisateur);
    void deleteById(int id);

}
