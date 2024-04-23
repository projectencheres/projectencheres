package fr.eni.projet_encheres.bo;

import java.util.Date;


public class Enchere {
    private int noEnchere;
    private Date dateEnchere;
    private Double montantEnchere;
    private int noArticle;
    private int noUtilisateur;
    
    // Getters and Setters
    
	public int getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public Double getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(Double montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

    
    
}
