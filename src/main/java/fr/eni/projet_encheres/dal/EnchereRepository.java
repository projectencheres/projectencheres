package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Enchere;

import java.util.List;

public interface EnchereRepository {

    List<Enchere> findAllEncheres();

    Enchere findById(int _id);
}
