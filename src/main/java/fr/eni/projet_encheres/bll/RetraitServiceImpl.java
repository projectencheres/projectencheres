package fr.eni.projet_encheres.bll;

import fr.eni.projet_encheres.bo.Retrait;
import fr.eni.projet_encheres.dal.RetraitRepository;
import fr.eni.projet_encheres.exceptions.RetraitNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetraitServiceImpl implements RetraitService{

    private RetraitRepository retraitRepository;
    @Override
    public List<Retrait> findAllRetraits() {
        return retraitRepository.findAllRetraits();
    }

    @Override
    public Optional<Retrait> findById(int noRetrait) throws RetraitNotFoundException {
        return retraitRepository.findById(noRetrait);
    }

    @Override
    public void save(Retrait retrait) {
        retraitRepository.save(retrait);
    }
}
