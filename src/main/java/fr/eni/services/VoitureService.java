package fr.eni.services;

import java.util.List;

import fr.eni.beans.Voiture;
import fr.eni.dao.VoitureDAO;

public class VoitureService {
	
	VoitureDAO voitureDAO = new VoitureDAO();
	
	public Voiture getVoiture(String immatriculation) throws Exception{
		return this.voitureDAO.getVoiture(immatriculation);
	}
	
	public void ajouterVoiture(Voiture nouvelleVoiture) throws Exception{
		this.voitureDAO.ajouterVoiture(nouvelleVoiture);
	}
	
	public void modifierVoiture(Voiture voitureAModifier) throws Exception{
		this.voitureDAO.modifierVoiture(voitureAModifier);
	}
	
	public void supprimerVoiture(String immatriculation) throws Exception{
		this.voitureDAO.supprimerVoiture(immatriculation);
	}
	
	public List<Voiture> getListeVoitures() throws Exception{
		return voitureDAO.getListeVoitures();
	}

}
