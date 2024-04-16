package Flite_Booking_App_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Flite_Booking_App_DBO.Database_Connection1;

@WebServlet("/add_flite")
public class Admin_servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String useremail = (String) session.getAttribute("user2");

        try {
 

        	Connection con = Database_Connection1.DB_Connection();
            String query = "SELECT * FROM All_flites";
            
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(query);
            out.print("<h1>All Available Flights</h1>");
            out.print("<html><body bgcolor=green><table border=7 style='width: 70%; '><tr><td>Date</td><td>From</td><td>Destination</td><td>Fare</td><td>Time</td><td>ID</td></tr>");
            out.print("<form action='Insert.jsp'><button style='background-color: green; color: white; padding: 10px 20px; border: none; cursor: pointer;'>Add Flight</button></form>");
            while (rs.next()) {
                out.print("<tr><td>" + rs.getDate(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
                        + "</td><td>" + rs.getInt(4) + "</td><td>"+ rs.getTime(5)+"</td><td>"+ rs.getInt(6)+"</td><td><form action='Update.jsp' method='post'>"
                        +"<input type='hidden' name='editId' value='" +rs.getInt(6)+"|" + rs.getDate(1)+"|" +rs.getString(2)+"|" +rs.getString(3)+"|" +rs.getInt(4)+"|" +rs.getTime(5)+"'>"
                        +"<button style='background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer;' type='submit' >Edit</button></form></td>"
                        +"<td><form action='delete1' method='post'>"
                        +"<input type='hidden' name='deleteId' value='" +rs.getInt(6)+"'>"
                        +"<button style='background-color: red; color: white; padding: 5px 10px; border: none; cursor: pointer;' type='submit'>Delete</button></form></td></tr>");
            }
            out.print("</table></body></html>");
            
             
        } catch (Exception e) {
            e.printStackTrace();
            out.print("An error occurred while processing your request.");
        }
    }
}
