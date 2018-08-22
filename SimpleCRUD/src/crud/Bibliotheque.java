package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bibliotheque {

	public void recupererMesDonnes() {
		String url = "jdbc:mysql://localhost/bibliotheque_bd";
		String user = "root";
		String pwd = "rootpwd";

		Connection cn = null;
		Statement st = null;

		// connexion avec le driver
		try {
			//chargement du Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver ok! :) ");
			// recuperation de la connexion
			cn =DriverManager.getConnection(url, user, pwd);
			// creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM bibliotheque_bd.livre";
			//execution requete
			ResultSet result = st.executeQuery(sql);

			int idTable;
			String nomDuLivre;
			String nomAuteur;
			while (result.next()) {
				//recuperer l''idPersonne"
				idTable = result.getInt("idTable");
				//recuperer le "Nom"
				nomDuLivre = result.getString("nomDuLivre");
				//recuperer le "Prenom"
				nomAuteur = result.getString("nomAuteur");
				

				System.out.println(idTable + " > " + nomDuLivre + " " + nomAuteur 
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//Connexion avec le server mySQL

		Bibliotheque c = new Bibliotheque();
		c.recupererMesDonnes();

	}

}
