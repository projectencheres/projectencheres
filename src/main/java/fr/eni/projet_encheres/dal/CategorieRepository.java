package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository {

    List<Categorie> findAllCategories();

    Optional<Categorie> findById(int id);
}
