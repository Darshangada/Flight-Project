<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Values</title>
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
    <% String editIdValue = request.getParameter("editId"); %>
    <% String[] values = editIdValue.split("\\|"); %>
    <% int flightId = Integer.parseInt(values[0]); %>
    <% java.sql.Date flightDate = java.sql.Date.valueOf(values[1]); %>
    <% String flightFrom = values[2]; %>
    <% String flightDestination = values[3]; %>
    <% int flightFare = Integer.parseInt(values[4]); %>
    <% java.sql.Time flightDuration = java.sql.Time.valueOf(values[5]); %>
    <% session = request.getSession();
    String useremail = (String) session.getAttribute("user2"); %>

    <h1 align="center">Update Flight Details</h1>
    <div class="edit">
    <form action="Update" method="post">
        <input type="hidden" name="flightId" value="<%= flightId %>">
        <p>Date: <input type="date" name="flightDate" value="<%= flightDate %>"></p>
        <p>From: <input type="text" name="flightFrom" value="<%= flightFrom %>"></p>
        <p>Destination: <input type="text" name="flightDestination" value="<%= flightDestination %>"></p>
        <p>Fare: <input type="text" name="flightFare" value="<%= flightFare %>"></p>
        <p>Time: <input type="time" name="flightDuration" value="<%= flightDuration %>"></p>
        <button type="submit">Update</button>
    </form>
    </div>
</body>
</html>
