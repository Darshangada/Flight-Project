<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User Here</title>
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
 
 <% if(request.getAttribute("message1") != null) { %>
    <div class="message">
        <!-- Place where you want to display the value -->
        <h3><%= request.getAttribute("message1") %></h3>
    </div>
<% } %>
 <div class="edit">
 <form action="Register1" method="post">
 		Name:<input type="text" placeholder="Enter Name" name="name" required="required"><br><br>
		Email:<input type="email" placeholder="Enter Email" name="Email1" required="required"><br><br>
		Mo.No:<input type="text" placeholder="Enter mobile number" name="number" required="required"><br><br>
		Password:<input	type="password" placeholder="Enter password" name="pass1"  title="Password must contain 
		at least one lowercase letter,
		one uppercase letter, 
		one digit, 
		one special character,
		and be at least 6 characters long" required="required"><br><br>
		User-Type: <select name="UserId">
			<option value="Na">Select option</option>
			<option value="admin">Admin</option>
			<option value="user">User</option>
		</select><br><br>
            
		<button style="align-items: center" type="submit">Register</button>
	</form>
	</div>
</body>
</html>