package Flite_Booking_App_Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Flite_Booking_App_DBO.Database_Connection1;

@WebServlet("/check_usertype")
public class Userytype_check extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String useremail = (String) session.getAttribute("user1");
        System.out.println(useremail);

        try {
            Connection conn =Database_Connection1.DB_Connection();
            PreparedStatement ps = conn.prepareStatement("SELECT User_Type FROM Flite_Details WHERE Email=?");
            ps.setString(1, useremail);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String userType = rs.getString("User_Type");
                System.out.println(userType);
                if ("admin".equalsIgnoreCase(userType)) {
                    // Forward to add_flite.jsp if user is admin
                 RequestDispatcher rd=request.getRequestDispatcher("add_flite");
                 rd.forward(request, response);
                } else {
                	
                	request.setAttribute("message2","You are not authorized to access this page");
    				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
    				rd.forward(request, response);
                  
                }
            } else {
                // Handle case where user doesn't exist
            	
             	
             	request.setAttribute("message4","You are not login, login first.");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}

