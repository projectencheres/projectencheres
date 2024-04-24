package fr.eni.projet_encheres.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.projet_encheres.bll.UtilisateurService;

@Controller
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
}