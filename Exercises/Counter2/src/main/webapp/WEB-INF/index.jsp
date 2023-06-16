<%@ page import="com.counter2.counter2.Counter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    int visitsCount = (int)request.getAttribute("visitsCount");
%>
<html>
<head>
    <title>Counter 2</title>
</head>
<body>
    <%= "<h1>Number of Visits => " + visitsCount + "</h1>"%>
</body>
</html>