package Flite_Booking_App_Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Flite_Bookiing_App_Model.Insert;
import Flite_Booking_App_DBO.Database_connection2;

@WebServlet("/Insert")
public class insert_data extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 HttpSession session = request.getSession();
	     String useremail = (String) session.getAttribute("user2");
		
		String dateStr = request.getParameter("date");
        String source = request.getParameter("source");
        String Destination = request.getParameter("destination");
        String fareStr = request.getParameter("fare");
        String time = request.getParameter("time");

        // Convert string values to appropriate types
        // Handle validation as needed
        try {
        Insert s1 = new Insert();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println("1------------------");
        Date date=null;
        s1.setDate( date = dateFormat.parse(dateStr));
        s1.setSource(source);
        s1.setDestination(Destination);
        s1.setFare(Double.parseDouble(fareStr));
        s1.setTime(time);
//       System.out.println("2------------------");

        Database_connection2  DB1 = new Database_connection2();
        DB1.insertvalue(s1);
        PrintWriter out=response.getWriter();
        out.print("Data insert successfullay");
        RequestDispatcher rd=request.getRequestDispatcher("add_flite");
        rd.include(request, response);
//        System.out.println("3------------------");
        }
        catch (Exception e) {
			// TODO: handle exception
		}
	}
}
