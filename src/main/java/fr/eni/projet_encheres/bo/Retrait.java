package fr.eni.projet_encheres.bo;

public class Retrait {
    private Long noRetrait;
    private String rue;
    private String codePostal;
    private String ville;

    // Getters and Setters
	public Long getNoRetrait() {
		return noRetrait;
	}
	public void setNoRetrait(Long noRetrait) {
		this.noRetrait = noRetrait;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

    
}
