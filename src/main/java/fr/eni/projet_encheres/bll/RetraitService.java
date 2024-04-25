package fr.eni.projet_encheres.bll;

import fr.eni.projet_encheres.bo.Retrait;
import fr.eni.projet_encheres.exceptions.RetraitNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RetraitService {

    List<Retrait> findAllRetraits();

    Optional<Retrait> findById(int noRetrait) throws RetraitNotFoundException;

    void save(Retrait retrait);

}
