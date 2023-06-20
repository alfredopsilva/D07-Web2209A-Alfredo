<%--
  Created by IntelliJ IDEA.
  User: alfredoparreira
  Date: 2023-06-19
  Time: 3:04 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = (String)request.getAttribute("name");
    String color = (String)request.getAttribute("color");
    boolean remember = (Boolean)request.getAttribute("remember");
%>


<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="color:pink;">Teste</h1>
    <%="<h1 style='color: " + color != null ? color : "black " + " ;>" + "Hello " + name + "</h1>" %>
    <% if(remember){%>
        <p>We have remembered your name and color. They are stored in your cookies.</p>
        <ul>
            <li>Name: <%=name%></li>
            <li>Color: <%=color%></li>
        </ul>
    <%}
      else
      {%>
        <p>We have forgotten your name and color. They are not stored in your cookies.</p>
    <%}%>
    <a href="preference">Return</a>

</body>
</html>
