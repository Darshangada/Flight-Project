<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <style type="text/css">
        .edit {
            background-color: pink;
            border: 2px solid red;
            width: 400px;
            margin: 20px auto; /* Center the form horizontally */
            padding: 20px;
        }
        .edit input {
            padding: 5px;
            margin: 5px;
            text-align: center;
        }
        .edit button {
            display: block; /* Make the button a block-level element */
            margin: 0 auto; /* Center the button horizontally */
            padding: 10px 20px;
        }
        
          .edit button:hover {
        background-color: #45a049; /* Darker background color on hover */
    }
        .message {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <jsp:include page="index.jsp"></jsp:include>

    <%

for (int i = 1; i <= 6 ; i++) {
    String attributeName = "message" + i;
    Object attributeValue = request.getAttribute(attributeName);
    if (attributeValue != null) {
%>
    <div class="message">
        <h3><%= attributeValue %></h3>
    </div>
    
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires",0);
response.setHeader("Pragma","no-cache");
    }
}
    
   
%>
    <div class="edit">
        <form action="login" method="post">
            Email:<input type="email" placeholder="Enter Email" name="Email2"><br><br> 
            Password:<input type="password" placeholder="Enter password" name="pass2"><br><br>           
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
