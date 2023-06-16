<%--
  Created by IntelliJ IDEA.
  User: alfredoparreira
  Date: 2023-06-16
  Time: 4:32 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Form</title>
</head>
<body>
<form action="/preferences" method="POST">
    <fieldset>
        <label for="name">name</label>
        <input type="text" name="name" id="name">
        <label for="color">Color</label>
        <select name="color" id="color">
            <option value="red">Red</option>
            <option value="red">Blue</option>
            <option value="red">Green</option>
        </select>
        <div>
            <label for="preferences">Remember preferences</label>
            <input type="checkbox" name="preferences" id="preferences">
        </div>
        <input type="submit" value="Submit">
    </fieldset>
</form>
</body>
</html>
