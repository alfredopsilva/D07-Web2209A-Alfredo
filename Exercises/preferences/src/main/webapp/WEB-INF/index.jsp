<%--
  Created by IntelliJ IDEA.
  User: alfredoparreira
  Date: 2023-06-19
  Time: 2:39 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Form</title>
</head>
<body>
<form action="preference" method="POST">
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="color">Color</label>
    <select id="color" name="color">
        <option value="blue">Blue</option>
        <option value="red">Red</option>
        <option value="green">Green</option>
    </select>
    <div>
        <label for="remember">Remember Preferences</label>
        <input type="checkbox" name="remember" id="remember" value="true">
    </div>
    <input type="submit" value="Submit">
</form>
</body>
</html>
