package fr.eni.projet_encheres.controllers;


import java.security.Principal;
import java.util.Optional;

import org.springframework.boot.context.properties.bind.BindResult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import fr.eni.projet_encheres.bll.UtilisateurService;
import fr.eni.projet_encheres.bo.Utilisateur;
import fr.eni.projet_encheres.exceptions.UtilisateurNotFound;

@Controller
@SessionAttributes({"userConnected"})
@RequestMapping("/utilisateurs")
public class UtilisateurController {

	private final UtilisateurService utilisateurService;

	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@GetMapping
	public String listAllUtilisateurs(Model model) {
		model.addAttribute("utilisateurs", utilisateurService.findAll());

		return "utilisateurs";
	}

	@GetMapping("/{id}/voir")
	public String showUtilisateur(@PathVariable("id") int noUtilisateur, Model model) throws UtilisateurNotFound {
		Utilisateur utilisateur = utilisateurService.findById(noUtilisateur);
		model.addAttribute("utilisateur", utilisateur);

		return "showUtilisateur";
	}

	@PostMapping("/modifier")
	public String updateUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult resultat) {
		if (resultat.hasErrors()) {
			return "utilisateurs/modifier";
		}

		utilisateurService.updateProfil(utilisateur);

		return "redirect:/utilisateurs";
	}

	@GetMapping("/{id}/modifier")
	public String updateUtilisateur(@PathVariable("id") int noUtilisateur, Model model) throws UtilisateurNotFound {

		Utilisateur utilisateur = utilisateurService.findById(noUtilisateur);
		model.addAttribute("utilisateur", utilisateur);

		return "updateUtilisateur";
	}
	
	
	@GetMapping("/{id}/supprimer")
	public String deleteProfil(@PathVariable("id") int idUtilisateur) {
		utilisateurService.deleteProfil(idUtilisateur);
		return "redirect:/utilisateurs";
	}
	
	@GetMapping("/mon-profil")
	public String afficherProfilUtilisateur( @ModelAttribute("userConnected") Utilisateur utilisateurConnected, Model model) {
	        
//		model.addAttribute("utilisateur", utilisateurConnected);
	        
	    return "monProfil";
	}
	
	@PostMapping("/mon-profil")
	public String updateProfil(@ModelAttribute("userConnected") Utilisateur utilisateurConnected, BindingResult resultat) {
		if (resultat.hasErrors()) {
            return "utilisateurs/mon-profil";
        }
		
		utilisateurService.updateProfil(utilisateurConnected);
		
		return "redirect:/encheres";
	}
}
