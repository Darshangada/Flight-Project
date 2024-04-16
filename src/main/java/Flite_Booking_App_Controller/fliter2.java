package Flite_Booking_App_Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Flite_Booking_App_DBO.Database_Connection1;


public class fliter2 implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	    HttpSession session = httpRequest.getSession(false); // Do not create a new session if one doesn't exist

	    // Check if the user is logged in
	    if (session == null || session.getAttribute("user1") == null) {
	        // User is not logged in, forward to login page
	        request.getRequestDispatcher("/Login.jsp").forward(request, response);
	        return;
	    }

	    // User is logged in, allow the request to proceed
	    chain.doFilter(request, response);
	}
	
	
}
