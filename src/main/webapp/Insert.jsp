<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
<style type="text/css">
        .edit {
            background-color: blue;
            border: 4px solid white;
            border-radius:20px;
            width: 400px;
            margin: 20px auto; /* Center the form horizontally */
            padding: 20px;
            position: relative;top: 100px;
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
<body bgcolor="pink">
<%
response.setContentType("text/html");
 session = request.getSession();
String useremail = (String) session.getAttribute("user2");
%>
<div class="edit">
<form action="Insert" method="post">
 		<input type="date"  placeholder="Enter Date yy-mm-dd" name="date" required="required"><br><br>
		<input type="text" placeholder="Enter source" name="source" required="required"><br><br>
		<input type="text" placeholder="Enter Destination" name="destination" required="required"><br><br>
		<input type="text" placeholder="Enter Fare" name="fare" required="required"><br><br>
		<input type="time" placeholder="Enter time hh:mm:ss" name="time" required="required"><br><br>
		<button >Submit</button>
</form>
</div>
</body>
</html>