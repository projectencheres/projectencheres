package fr.eni.projet_encheres.bll;

import java.util.List;
import java.util.Optional;


import fr.eni.projet_encheres.bo.Utilisateur;
import fr.eni.projet_encheres.exceptions.UtilisateurNotFound;

public interface UtilisateurService {
    void deleteProfil(int idUtilisateur);
    void updateProfil( Utilisateur utilisateur);
    List<Utilisateur> findAll();
    Utilisateur findById(int noUtilisateur) throws UtilisateurNotFound;
    Optional<Utilisateur> findByPseudoOrEmail(String identifiant);
    void save(Utilisateur utilisateur);
    Utilisateur findByPseudo(String pseudo);

}
