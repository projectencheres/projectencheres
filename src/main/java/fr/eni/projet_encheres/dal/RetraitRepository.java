package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Retrait;

import java.util.List;
import java.util.Optional;

public interface RetraitRepository {

    List<Retrait> findAllRetraits();

    Optional<Retrait> findById(int noRetrait);

    void save(Retrait retrait);

}
