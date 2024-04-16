package Flite_Booking_App_DBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Flite_Bookiing_App_Model.Insert;

public class Database_connection2 {
	
	 private static final String URL = "jdbc:mysql://localhost:3306/CSj32";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Darshan123";

	    public void insertvalue(Insert insert) {
	        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
	            String query = "INSERT INTO All_flites (Date,Source,Destination, Fare,Duration) VALUES (?, ?, ?, ?, ?)";
	            try (PreparedStatement pt = connection.prepareStatement(query)) {
	                pt.setDate(1, new java.sql.Date(insert.getDate().getTime()));
	                pt.setString(2, insert.getSource());
	                pt.setString(3, insert.getDestination());
	                pt.setDouble(4, insert.getFare());
	                pt.setString(5, insert.getTime());
	               
	                pt.executeUpdate();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
