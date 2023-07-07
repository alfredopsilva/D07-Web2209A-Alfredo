<%@ page import="ca.collegeuniversel.recipes.entities.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // TODO
    User loggedUser = (User) session.getAttribute("loggedUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recipes</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body class="container vertical">
        <!-- TODO -->
    <h1>WELCOME <%=loggedUser.getName()%></h1>
    <div class="recipe__buttons">
        <a href="<%=request.getContextPath()%>/logout" class="recipe__button">Log out</a>
        <a href="<%=request.getContextPath()%>/add" class="recipe__button">Add recipe</a>
    </div>
    </body>
</html>
