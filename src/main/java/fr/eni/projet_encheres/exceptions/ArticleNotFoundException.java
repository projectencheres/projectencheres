package fr.eni.projet_encheres.exceptions;

public class ArticleNotFoundException extends Exception {
	private int idArticle;
	
	public ArticleNotFoundException(int idArticle) {
		this.idArticle = idArticle;
	}
	
	@Override
	public String getMessage() {
		
		return "Le Article " + idArticle + " n'a pas été trouvé.";
	}
}
