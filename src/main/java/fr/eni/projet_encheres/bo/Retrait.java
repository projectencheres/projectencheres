package fr.eni.projet_encheres.bo;

public class Retrait {
	private int noRetrait;
	private String rue;
	private String codePostal;
	private String ville;

	public Retrait(String _rue, String _codePostal, String _ville) {
		this.rue = _rue;
		this.codePostal = _codePostal;
		this.ville = _ville;
	}

	public Retrait() {
	}

	// Getters and Setters
	public int getNoRetrait() {
		return noRetrait;
	}

	public void setNoRetrait(int noRetrait) {
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

	@Override
	public String toString() {
		return "Retrait [noRetrait=" + noRetrait + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}

}
