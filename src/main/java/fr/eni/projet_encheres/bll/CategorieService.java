package fr.eni.projet_encheres.bll;

import fr.eni.projet_encheres.bo.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieService {

    List<Categorie> findAllCategories();

    Optional<Categorie> findById(int id) throws Exception;
}
