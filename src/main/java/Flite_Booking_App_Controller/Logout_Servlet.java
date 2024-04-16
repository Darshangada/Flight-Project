package Flite_Booking_App_Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout_Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        String useremail = (String) session.getAttribute("user1");
        if (session != null && useremail != null) {
            session.invalidate();

           
            PrintWriter out = resp.getWriter();
            req.setAttribute("message1", "logout Successfully");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("Login.jsp"); // Redirect to login page
        }
    }
}
