package fr.eni.beans;

public class Voiture {
	
	private static final long serialVersionUID = -1;
	
	private String marque;
	private String modele;
	private int kilometrage;
	private String immatriculation;
	private int annee;
	
	public Voiture() {
	}
	

	public Voiture(String marque, String modele, int kilometrage, String immatriculation, int annee) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.kilometrage = kilometrage;
		this.immatriculation = immatriculation;
		this.annee = annee;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public int getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}


	public String getImmatriculation() {
		return immatriculation;
	}


	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((immatriculation == null) ? 0 : immatriculation.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		if (immatriculation == null) {
			if (other.immatriculation != null)
				return false;
		} else if (!immatriculation.equals(other.immatriculation))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", modele=" + modele + ", kilometrage=" + kilometrage
				+ ", immatriculation=" + immatriculation + ", annee=" + annee + "]";
	}



}
