package fr.eni.projet_encheres.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.projet_encheres.bo.Utilisateur;
import fr.eni.projet_encheres.dal.UtilisateurRepository;
import fr.eni.projet_encheres.exceptions.UtilisateurNotFound;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public void deleteProfil(int idUtilisateur) {
        utilisateurRepository.deleteById(idUtilisateur);
		
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findById(int noUtilisateur) throws UtilisateurNotFound {
    Optional<Utilisateur> optUtilisateur = utilisateurRepository.findById(noUtilisateur);
    
    if (optUtilisateur.isEmpty()) {
    	throw new UtilisateurNotFound(noUtilisateur);
    }
    	return optUtilisateur.get();
    }

	@Override
	public void updateProfil(Utilisateur utilisateur) {
		utilisateurRepository.update(utilisateur);
	}

    @Override
    public Optional<Utilisateur> findByPseudo(String pseudo) {
        return utilisateurRepository.findByPseudo(pseudo);
    }

    @Override
    public void save(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }
}
