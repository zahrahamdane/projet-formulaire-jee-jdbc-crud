package fr.eni.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Fournir une connexion disponible dans le pool de connection
 */

public class FournisseurConnection {
	
	public static Connection getConnection() throws Exception {
		try {
			// Pour recuperer un context nous permettons de rechercher dans les variables d'environnement de l'API JDBC
			Context context = new InitialContext();
			
			// lookp va nous permettre de rechercher un ressource nommé bddVoiture
			DataSource ds = (DataSource)context.lookup("java:comp/env/bddVoitures");
			
			// Grace à la DataSource on peut obtenir une cnx
			return ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Problème d'accés à la base de données.", e);
		}
	}
}
