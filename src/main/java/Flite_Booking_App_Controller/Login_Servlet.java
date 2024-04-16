package Flite_Booking_App_Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
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

@WebServlet("/login")
public class Login_Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String Emailid = req.getParameter("Email2");
		String Pswd = req.getParameter("pass2");
		
		HttpSession seccsion = req.getSession();
		seccsion.setAttribute("user1", Emailid);
		seccsion.setAttribute("user2", Emailid);
		
		

		try {
			Connection con = Database_Connection1.DB_Connection();

			Statement st = con.createStatement();
			String Query = String.format("select Email,Password from Flite_Details where Email=('%s') and Password=('%s')", Emailid, Pswd);
			ResultSet rs = st.executeQuery(Query);
			
			if (rs.next()) {
				
				resp.sendRedirect("index.jsp");
			} else {

				out.print("<h1> you have not register user </h1>");
				RequestDispatcher rq = req.getRequestDispatcher("Register.jsp");
				rq.include(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
