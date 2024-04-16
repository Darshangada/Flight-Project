package Flite_Booking_App_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Flite_Booking_App_DBO.Database_Connection1;

@WebServlet("/home")
public class Home_Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String useremail = (String) session.getAttribute("user2");

        try {

            Connection con = Database_Connection1.DB_Connection();
            Statement st = con.createStatement();

            String Query = "select Date,Source,Destination,Fare,Duration from All_flites";
            ResultSet rs = st.executeQuery(Query);

            out.print("<h1>All Available Flights</h1>");
            out.print("<html><body style='background-color:green'><table border=7 style='width: 70%; '><tr><td>Date</td><td>From</td><td>Destination</td><td>Fare</td><td>Time</td></tr>");
            while (rs.next()) {
                out.print("<tr><td>" + rs.getDate(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
                        + "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getTime(5) + "</td><td style='text-align: center;'>"
                        + "<form action='Flite_book.jsp'><button style='background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer;' type='submit'>Book</button></form></td></tr>");
            }
            out.print("</table></body></html>");

        } catch (Exception e) {
            // Handle exception properly
        }

    }
}
