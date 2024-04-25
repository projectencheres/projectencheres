package fr.eni.projet_encheres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import fr.eni.projet_encheres.bo.Utilisateur;
import fr.eni.projet_encheres.dal.UtilisateurRepository;

public class StringToUtilisateurConverter implements Converter <String, Utilisateur> {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur convert(String idUtilisateur) {
		int id = 0;
		try {
			id= Integer.parseInt(idUtilisateur);
			
		}catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return utilisateurRepository.findById(id).orElse(null);
		
	}
}
