package Flite_Booking_App_DBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Flite_Bookiing_App_Model.User_Details;

public class Database_Connection3 {

   
	String url = "jdbc:mysql://localhost:3306/CSj32";
	String username = "root";
	String password = "Darshan123";

	int result;
	public int insertdetails(User_Details UD) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			String query = "INSERT INTO Flite_Details (Name, Email, Ph_Number, Password, User_Type) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pt = con.prepareStatement(query);
			pt.setString(1, UD.getName());
			pt.setString(2, UD.getEmail());
			pt.setString(3, UD.getMobile_no());
			pt.setString(4, UD.getPassword());
			pt.setString(5, UD.getUsertype());

			 result = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
