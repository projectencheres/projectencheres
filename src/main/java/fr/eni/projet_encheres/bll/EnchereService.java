package fr.eni.projet_encheres.bll;

import fr.eni.projet_encheres.bo.Enchere;

import java.util.List;
import java.util.Map;

public interface EnchereService {
    List<Enchere> findAllEncheres();
    List<Enchere> findByName(String _name);
    List<Enchere> findByCategorie( int noCategorie);
    List<Enchere> findByNameAndCategorie(String _name, int noCategorie);
    Map<String, Object> customFindById(int noEnchere, String sessionUserIdentifiant);
}
