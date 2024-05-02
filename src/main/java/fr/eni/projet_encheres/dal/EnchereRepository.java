package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Enchere;

import java.util.List;
import java.util.Map;

public interface EnchereRepository {

    List<Enchere> findAllEncheres();
    Enchere findById(int noEnchere);
    List<Enchere> findByName(String _name);
    List<Enchere> findByCategorie(int noCategorie);
    List<Enchere> findByNameAndCategorie(String _name, int noCategorie);
    Map<String, Object> customFindById(int noEnchere, String sessionUserIdentifiant);
}
