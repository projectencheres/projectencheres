package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Retrait;

import java.util.List;
import java.util.Optional;

public interface RetraitRepository {

    List<Retrait> findAllRetraits();

    Optional<Retrait> findById(int noRetrait);

    Optional<Retrait> findByExactField(Retrait retrait);

    Retrait saveOnNotFound(Retrait _retrait);

    void onlySave(Retrait retrait);

    void save(Retrait retrait);

}
