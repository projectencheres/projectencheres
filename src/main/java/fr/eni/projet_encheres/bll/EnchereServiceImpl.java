package fr.eni.projet_encheres.bll;

import fr.eni.projet_encheres.bo.Enchere;
import fr.eni.projet_encheres.dal.EnchereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnchereServiceImpl implements EnchereService{

    private EnchereRepository enchereRepository;

    public EnchereServiceImpl(EnchereRepository enchereRepository) {
        this.enchereRepository = enchereRepository;
    }

    @Override
    public List<Enchere> findAllEncheres() { return enchereRepository.findAllEncheres();  }

/*     @override
    public List<Enchere> findByName() {
        List<Enchere> list;
        return list;
    }

    @override
    public List<Enchere> findByCategorie() {
        List<Enchere> list;
        return list;
    }

    @Override
    public List<Enchere> findByNameAndCategorie() {
        List<Enchere> list;
        return list;
    } */
}
