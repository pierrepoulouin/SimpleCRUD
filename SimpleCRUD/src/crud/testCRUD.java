package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testCRUD {

	public void recupererMesDonnes() {
		String url = "jdbc:mysql://localhost/formation";
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
			String sql = "SELECT * FROM formation.personne";
			//execution requete
			ResultSet result = st.executeQuery(sql);

			int idPersonne;
			String nom;
			String prenom;
			int flightno;
			while (result.next()) {
				//recuperer l''idPersonne"
				idPersonne = result.getInt("idPersonne");
				//recuperer le "Nom"
				nom = result.getString("nom");
				//recuperer le "Prenom"
				prenom = result.getString("prenom");
				//recuperer le "Flightno"
				flightno = result.getInt("flightno");

				System.out.println(idPersonne + " > " + nom + " " + prenom +
						" has taken : " + flightno);
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

		testCRUD c = new testCRUD();
		c.recupererMesDonnes();

	}

}
