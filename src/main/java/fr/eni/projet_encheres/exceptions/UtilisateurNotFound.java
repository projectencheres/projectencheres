package fr.eni.projet_encheres.exceptions;

public class UtilisateurNotFound extends Exception {
	private int idUtilisateur;

	public UtilisateurNotFound(int idUtilisateur) {
		
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public String toString() {
		return "L'utilisateur " + idUtilisateur + " n'a pas été trouvé.";
	}


	
	
	

}
