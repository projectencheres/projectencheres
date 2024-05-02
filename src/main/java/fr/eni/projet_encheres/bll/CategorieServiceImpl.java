package fr.eni.projet_encheres.bll;

import fr.eni.projet_encheres.bo.Categorie;
import fr.eni.projet_encheres.dal.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAllCategories();
    }

    @Override
    public Optional<Categorie> findById(int noCategorie) throws Exception {

        Optional<Categorie> optionalCategorie = categorieRepository.findById(noCategorie);

        if (optionalCategorie.isEmpty()) {
            throw new Exception("Not found");
        }
        return optionalCategorie;
    }
}
