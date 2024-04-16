package Flite_Booking_App_DBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection1 {

	public static Connection DB_Connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/CSj32";
		String user_name = "root";
		String pass = "Darshan123";

		Connection con = DriverManager.getConnection(url, user_name, pass);
		return con;

	}
}
