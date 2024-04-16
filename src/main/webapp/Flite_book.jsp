<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpSession s1 = request.getSession(true);
	String User = (String) s1.getAttribute("user1");
	System.out.print(User);
	
	if (User != null) {
		out.print("your flite is book successfully");
		RequestDispatcher rd = request.getRequestDispatcher("home");
		rd.include(request, response);
		
	} else {
		
		request.setAttribute("message2","You are not logged in. Please login first.");
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}
	
	%>

</body>
</html>