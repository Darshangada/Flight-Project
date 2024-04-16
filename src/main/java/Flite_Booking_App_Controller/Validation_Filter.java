package Flite_Booking_App_Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/Register1")
public class Validation_Filter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		String pswd = request.getParameter("pass1");

		if (pswd != null && pswd.length() >= 6) {
			boolean Uppercase = false;
			boolean Lowercase = false;
			boolean Digit = false;
			boolean SpecialChar = false;
			String specialchars = "@!$#";

			for (char ch : pswd.toCharArray()) {
				if (Character.isUpperCase(ch)) {
					Uppercase = true;
				} 
				else if (Character.isLowerCase(ch)) {
					Lowercase = true;
				}
				else if (Character.isDigit(ch)) {
					Digit = true;
				} 
				else if (specialchars.contains(String.valueOf(ch))) {
					SpecialChar = true;
				}
			}

			if (Uppercase && Lowercase && Digit && SpecialChar) {
				chain.doFilter(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("<h3>Invalid password</h3>");
				RequestDispatcher rd1=request.getRequestDispatcher("Register.jsp");
				rd1.include(request, response);
			}

		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request, response);	
		}
		
	}

}
