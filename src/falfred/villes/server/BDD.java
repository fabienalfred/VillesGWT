package falfred.villes.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql:///france";
	private static String user = "root";
	private static String password = "";
	
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(">>> Connexion réussie <<<");
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void disconnect(Connection conn) {
		try {
			conn.close();
			conn = null;
			System.out.println(">>> Déconnecté <<<");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
