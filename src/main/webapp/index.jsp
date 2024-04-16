<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flite Booking App</title>
<style>
body {
    background-image: url("https://i.pinimg.com/originals/97/d0/29/97d02982385f06e947f965cab0ac5d67.jpg");
    background-size: cover; /* This will adjust the image to cover the entire background */
    background-position: center; /* This will center the image */
    width: 100%; /* Adjust the width to fill the entire viewport */
    height: 100vh; /* Adjust the height to fill the entire viewport */
    margin: 0; /* Remove default margin */
    padding: 0; /* Remove default padding */
    overflow: hidden; /* Hide horizontal scrollbar */
}

nav {
    display: flex;
    background-color:blue;
    width: 1500px;
}

nav a {
    text-decoration: none;
    color: black;
}

nav a:hover {
    color: blue; /* Change color on hover */
}

button {
  background-color:white;	
    text:black;
    border: none;
    border-radius:10px;
    padding: 6px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

button:hover {
    background-color: green; /* Darker green on hover */
}
</style>
</head>
<body>
  
<header style="display: flex; align-items: center; position: relative; position: sticky;">
    <nav>
        <div style="display: flex; margin: auto; color: white;">
            <li style="list-style: none; padding: 6px 8px; font-size: 2rem; position: relative;right: 400px;">
                <a href='index.jsp'>Flight Booking App</a>
            </div>
            <div style="position: relative; right: 800px; margin-top: 15px">
                <form action="home">
                    <button type="submit">Home</button>
                </form>
            </div>
            <div style="position: relative; right: 750px;margin-top: 15px;">
                <form action="check_usertype" method="post">
                    <button type="submit">Add Flite</button>
                </form> 
            </div>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires",0);
response.setHeader("Pragma","no-cache");
session = request.getSession();
String useremail = (String) session.getAttribute("user1");
if(session !=null && useremail!=null){
%>
            <div style="position: relative;  right: 30px;margin-top: 15px;">
                <form action="logout">
                    <button type="submit">Logout</button>
                </form>
            </div>
            <div style="position: relative;  right: 20px;margin-top: -5px;">
                <h5><%= useremail %></h5>
            </div>
<%
}else{%>
            <div style="position: relative; right: 30px;margin-top: 15px;">
                <form action="Login.jsp">
                    <button type="submit">Login</button>
                </form>
            </div>
            <div style="position: relative; right: 10px;margin-top: 15px">
                <form action="Register.jsp">
                    <button type="submit">Register</button>
                </form>
            </div>
<%
} %>
        </nav>
    </header>
    <main>
        <section id="home">
            <h1 class="h-head">
                <marquee behavior="scroll" direction="Left">BOOK YOUR FLIGHT VERY FAST</marquee>
            </h1>
        </section>
    </main>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
