package fr.eni.servlets;

import java.io.IOException;
import java.util.HashMap;

import fr.eni.beans.Voiture;
import jakarta.servlet.http.HttpServletRequest;

public abstract class Validation {
	
	/**
	 * 
	 * @param request
	 * @return Un objet voiture valide ou null si au moins une saisie est mauvaise.
	 * @throws IOException
	 */
	
	public static Voiture validerSaisie(HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		HashMap<String, String> erreursDeSaisie = new HashMap<>();
		
		String marque = request.getParameter("marque");
		if(marque==null || marque.trim().isEmpty()) {
			erreursDeSaisie.put("marque", "La marque est obligatoire.");	
		}
		
		String modele = request.getParameter("modele");
		if(marque==null || marque.trim().isEmpty()) {
			erreursDeSaisie.put("modele", "Le modèle est obligatoire.");	
		}
		
		int kilometrage =0;
		try {
			kilometrage = Integer.parseInt(request.getParameter("kilometrage"));
		} catch (NumberFormatException e) {
			erreursDeSaisie.put("kilometrage","Le kilometrage est obligatoire et supérieur à 0.");
		}
		
		String immatriculation = request.getParameter("immatriculation");
		if(immatriculation == null || immatriculation.trim().isEmpty()) {
			erreursDeSaisie.put("immatriculation", "L'immatriculation est obligatoire.");
		}
		
		int annee = 0;
		try {
			annee = Integer.parseInt(request.getParameter("annee"));
			if(annee < 2015) {
				erreursDeSaisie.put("annee", "L'année est trop ancienne (minimum 2015).");
			}
		} catch (NumberFormatException e) {
			erreursDeSaisie.put("annee", "L'année est obligatoir et supérieur à 2015.");
		}
		
		if(erreursDeSaisie.size() == 0) {
			return new Voiture(marque, modele, kilometrage, immatriculation, annee);
		}else {
			request.setAttribute("erreursDeSaisie", erreursDeSaisie);
			return null;
		}
	}

}
