<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: alfredoparreira
  Date: 2023-06-19
  Time: 2:39 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String name = (String)request.getAttribute("name");
    String color = (String)request.getAttribute("color");

    int index = 0;

    if(color != null)
    {
        switch (color){
            case "red":
                index = 1;
                break;
            case "blue":
                index = 2;
                break;
            case "green":
                index = 3;
                break;
        }
    }

%>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Form</title>
</head>
<body>
<form action="preference" method="POST">
    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="<%= name != null  ? name : ""%>">
    <label for="color">Color</label>
    <select id="color" name="color">
        <option value="blue" <%=index == 2 ? "selected" : ""%>>Blue</option>
        <option value="red" <%=index == 1 ? "selected" : ""%>>Red</option>
        <option value="green"<%=index == 3 ? "selected" : ""%>>Green</option>
    </select>
    <div>
        <label for="remember">Remember Preferences</label>
        <input type="checkbox" name="remember" id="remember" value="true">
    </div>
    <input type="submit" value="Submit">
</form>
</body>
</html>
