<%@ page import="com.s.student2.models.Student" %><%--
  Created by IntelliJ IDEA.
  User: alfredoparreira
  Date: 2023-06-12
  Time: 3:02 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student)request.getAttribute("student");
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <%= "<title>Student - " + student.getFirstName() + "</title>"%>
</head>
<body>
    <%= "<h1 class='studentTitle'> Student " + student.getFullName() + "</h1>" %>
    <%= "<ul>" %>
        <%= "<li class='studentItem'><p>Id: " + student.getId() + "</p></li>" %>
        <%= "<li class='studentItem'><p>First Name: " + student.getFirstName() + "</p></li>" %>
        <%= "<li class='studentItem'><p>Last Name: " + student.getLastName() + "</p></li>" %>
        <%= "<li class='studentItem'><p>Date of Birth: " + student.getDateOfBirth() + "</p></li>" %>
        <%= "<li class='studentItem'><p>Age: " + student.getAge() + "</p></li>" %>
        <% if(student.isGraduate() == true){ %>
            <%= "<li class='studentItem'><p>Graduated</p></li>"%>
        <%} else {%>
            <%= "<li class='studentItem'><p>Not Graduated</p></li>"%>
        <%}%>
    <%="</ul>"%>
</body>
</html>
