package fr.eni.projet_encheres.bll;

import fr.eni.projet_encheres.bo.Enchere;

import java.util.List;

public interface EnchereService {
    List<Enchere> findAllEncheres();
/*     List<Enchere> findByName();
    List<Enchere> findByCategorie();
    List<Enchere> findByNameAndCategorie(); */
}
