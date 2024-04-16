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

import Flite_Bookiing_App_Model.User_Details;
import Flite_Booking_App_DBO.Database_Connection1;
import Flite_Booking_App_DBO.Database_Connection3;
import Flite_Booking_App_DBO.Database_connection2;

@WebServlet("/Register1")
public class Register_Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");
		String Emailid = req.getParameter("Email1");
		String Ph = req.getParameter("number");
		String Pswd = req.getParameter("pass1");
		String User_type = req.getParameter("UserId");

		try {
			User_Details UD= new User_Details();
			UD.setName(name);
			UD.setEmail(Emailid);
			UD.setMobile_no(Ph);
			UD.setPassword(Pswd);
			UD.setUsertype(User_type);
			
			Database_Connection3  DB3 = new Database_Connection3();
	        int result=DB3.insertdetails(UD);	
	      
			if (result > 0) {
				
				req.setAttribute("message6","You Register Successfully and go login page");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			} else {
				
				req.setAttribute("message1","please Enter valid details");
				RequestDispatcher rd=req.getRequestDispatcher("Register.jsp");
				rd.forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
