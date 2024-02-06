package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.beans.Voiture;

public class VoitureDAO {

	private static String INSERT = "INSERT INTO voitures (immatriculation, marque, modele, kilometrage, annee) VALUES(?,?,?,?,?)";
	private static String SELECT_ONE = "SELECT immatriculetion, marque, modele, kilometrage, annee FROM voitures WHERE immatriculation = ?";
	private static String SELECT_ALL = "SELECT immatriculetion, marque, modele, kilometrage, annee FROM voitures";
	private static String UPDATE = "UPDATE voitures SET marque=?, modele=?, kilometrage=?, annee=? WHERE immatriculation=?";
	private static String DELETE = "DELETE FROM voitures WHERE immatriculation=?";

	public Voiture getVoiture(String immatriculation) throws Exception {

		Voiture voiture = null;
		try (Connection cnx = FournisseurConnection.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SELECT_ONE)) {

			ps.setString(1, immatriculation);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				voiture = new Voiture();
				voiture.setImmatriculation(rs.getString("immatriculation"));
				voiture.setMarque(rs.getString("marque"));
				voiture.setModele(rs.getString("modele"));
				voiture.setKilometrage(rs.getInt("kilometrage"));
				voiture.setAnnee(rs.getInt("annee"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Erreur à la lecture de la voiture recherchée.", e);
		}
		return voiture;
	}

	public void ajouterVoiture(Voiture nouvelleVoiture) throws Exception {
		try (Connection cnx = FournisseurConnection.getConnection();
				PreparedStatement ps = cnx.prepareStatement(INSERT)) {
			ps.setString(1, nouvelleVoiture.getImmatriculation());
			ps.setString(2, nouvelleVoiture.getMarque());
			ps.setString(3, nouvelleVoiture.getModele());
			ps.setInt(4, nouvelleVoiture.getKilometrage());
			ps.setInt(5, nouvelleVoiture.getAnnee());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Erreur à l'enregistrement de la voiture.", e);
		}

	}

	public void modifierVoiture(Voiture voitureAModifier) throws Exception {
		try (Connection cnx = FournisseurConnection.getConnection();
				PreparedStatement ps = cnx.prepareStatement(UPDATE)) {
			ps.setString(1, voitureAModifier.getMarque());
			ps.setString(2, voitureAModifier.getModele());
			ps.setInt(3, voitureAModifier.getKilometrage());
			ps.setInt(4, voitureAModifier.getAnnee());
			ps.setString(5, voitureAModifier.getImmatriculation());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Erreur à la mise à jour de la voiture.", e);
		}
	}

	public void supprimerVoiture(String immatriculation) throws Exception {

		try (Connection cnx = FournisseurConnection.getConnection();
				PreparedStatement ps = cnx.prepareStatement(DELETE)) {
			ps.setString(1, immatriculation);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception ("Erreur à la suppression de la voiture.",e);
		}
	}
	
	public List<Voiture> getListeVoitures() throws Exception {
		List<Voiture> voitures = new ArrayList<>();
		try (Connection cnx = FournisseurConnection.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SELECT_ALL)){
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Voiture voiture = new Voiture();
					voiture.setImmatriculation(rs.getString("immatriculation"));
					voiture.setMarque(rs.getString("marque"));
					voiture.setModele(rs.getString("modele"));
					voiture.setKilometrage(rs.getInt("kilometrage"));
					voiture.setAnnee(rs.getInt("annee"));
					
					voitures.add(voiture);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Erreur à la lecture de la liste de voiture.",e);
		}
		
		return voitures;
	}

}
