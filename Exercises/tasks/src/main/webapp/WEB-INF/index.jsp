<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String message = (String)session.getAttribute("message");

%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>JSP - Hello World</title>
</head>
<body>
    <form action="task" method="post">
        <fieldset>
            <legend>Add Task</legend>
            <input type="text" name="taskName" id="task">
            <input type="submit" value="Add">
            <p><%=message%></p>
        </fieldset>
    </form>
    <form action="">
        <fieldset>
            <legend>Tasks</legend>
        </fieldset>
    </form>
</body>
</html>