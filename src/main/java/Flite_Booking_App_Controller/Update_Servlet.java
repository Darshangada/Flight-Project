package Flite_Booking_App_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Flite_Booking_App_DBO.Database_Connection1;

@WebServlet("/Update")
public class Update_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter();

	    String date1 = req.getParameter("flightDate");
	    String source = req.getParameter("flightFrom");
	    String destination = req.getParameter("flightDestination");
	    String time = req.getParameter("flightDuration");
	    String fare = req.getParameter("flightFare");

	    // Check for null values and trim if not null
	    if (date1 != null && source != null && destination != null && time != null && fare != null) {
	        date1 = date1.trim();
	        source = source.trim();
	        destination = destination.trim();
	        time = time.trim();
	        fare = fare.trim();
	    } else {
	        out.println("One or more input fields are empty.");
	        return; // Stop further execution if any parameter is null
	    }
	    
	    int id = 0;
	    try {
	        id = Integer.parseInt(req.getParameter("flightId"));
	    } catch (NumberFormatException e) {
	        out.println("Invalid ID provided.");
	        return; // Stop further execution if ID is not a valid integer
	    }

	    try {
	        Connection con = Database_Connection1.DB_Connection();
	        String query = "update All_flites set Date=?, Source=?, Destination=?, Fare=?, Duration=? where id=?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, date1);
	        ps.setString(2, source);
	        ps.setString(3, destination);
	        ps.setString(4, fare);
	        ps.setString(5, time);
	        ps.setInt(6, id);

	        int result = ps.executeUpdate();

	        if (result > 0) {
	            // Successful update
	            out.print("Record updated successfully");
	            RequestDispatcher rd = req.getRequestDispatcher("add_flite");
	            rd.include(req, resp); // Request to the updated value on flite page
	        } else {
	            out.print("Record not updated due to some problem");
	            RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
	            rd.include(req, resp);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        out.println("An error occurred while processing your request.");
	    }
	}

}
