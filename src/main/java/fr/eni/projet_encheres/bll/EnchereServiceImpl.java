package fr.eni.projet_encheres.bll;

import fr.eni.projet_encheres.bo.Enchere;
import fr.eni.projet_encheres.dal.EnchereRepository;
import fr.eni.projet_encheres.dal.override;

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

    @override
    public List<Enchere> findByName(String _name) {
        return enchereRepository.findByName(_name);
    }

    @override
    public List<Enchere> findByCategorie(int noCategorie) {
        return enchereRepository.findByCategorie(noCategorie);
    }

    @Override
    public List<Enchere> findByNameAndCategorie(String _name, int noCategorie) {
        return enchereRepository.findByNameAndCategorie(_name, noCategorie);
    }
}
