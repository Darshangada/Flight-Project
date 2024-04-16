package Flite_Booking_App_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Flite_Booking_App_DBO.Database_Connection1;

@WebServlet("/delete1")
public class Delete_servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        String useremail = (String) session.getAttribute("user2");
        try {
        	
            int id = Integer.valueOf(req.getParameter("deleteId"));
            Connection con = Database_Connection1.DB_Connection();
            String query = "DELETE FROM All_flites WHERE id = ?";
            	PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1,id);
                int result = ps.executeUpdate();
                System.out.println(result);
                if(result>0) {
                	out.print("record delete successfully");
                	RequestDispatcher rd=req.getRequestDispatcher("add_flite");
                	rd.include(req, resp);
                }
                else {
                	out.print("record not delete due to some problem");
                	RequestDispatcher rd=req.getRequestDispatcher("add_flite");
                	rd.include(req, resp);
                }
            // Optionally, you can redirect to another page after deletion
           
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred while processing your request.");
        }
    }

//    private int deleteFlight(int flightId) throws SQLException, ClassNotFoundException {
//        Connection con = Database_Connection1.DB_Connection();
//        String query = "DELETE FROM All_flites WHERE id = ?";
//        try (PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setInt(1, flightId);
//            int result = ps.executeUpdate();
//            return result;
//        }
//    }
}
