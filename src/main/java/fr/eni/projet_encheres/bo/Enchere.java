package fr.eni.projet_encheres.bo;

import java.util.Date;
import java.math.BigDecimal;

public class Enchere {
    private Long noEnchere;
    private Date dateEnchere;
    private BigDecimal montantEnchere;
    private Long noArticle;
    private Long noUtilisateur;
    
    // Getters and Setters
    
	public Long getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(Long noEnchere) {
		this.noEnchere = noEnchere;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public BigDecimal getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(BigDecimal montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public Long getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(Long noArticle) {
		this.noArticle = noArticle;
	}
	public Long getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(Long noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

    
    
}
