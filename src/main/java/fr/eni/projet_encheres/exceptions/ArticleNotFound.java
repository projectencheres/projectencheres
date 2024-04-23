package fr.eni.projet_encheres.exceptions;

public class ArticleNotFound extends Exception {
	private int idArticle;
	
	public ArticleNotFound(int idArticle) {
		this.idArticle = idArticle;
	}
	
	@Override
	public String getMessage() {
		
		return "Le Article " + idArticle + " n'a pas été trouvé.";
	}
}
