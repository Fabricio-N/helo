package cremosa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection connection = null;
	private static String url = "jdbc:mysql://localhost/locadora_ef";
	private static String user = "root";
	private static String senha = "ti72";

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, senha);

			} catch (ClassNotFoundException | SQLException e) {
				((Throwable) e).printStackTrace();
			}
		}

		return connection;
	}

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.getConnection();

		System.out.println(con);
		
		con.close();
	}
}