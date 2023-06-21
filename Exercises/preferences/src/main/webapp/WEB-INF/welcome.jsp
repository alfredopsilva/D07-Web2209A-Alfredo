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
    String rememberParameter = (String)request.getAttribute("remember");
    boolean remember = Boolean.parseBoolean(rememberParameter);
%>


<html>
<head>
    <title>Title</title>
</head>
<body>
    <% if(remember){%>
        <h1 style="color:<%=color != null ? color : "black"%>">Hello <%=name%></h1>
        <p>We have remembered your name and color. They are stored in your cookies.</p>
        <ul>
            <li>Name: <%=name%></li>
            <li>Color: <%=color%></li>
        </ul>
    <%}
      else
      {%>
        <h1 style="color:<%=color != null ? color : "black"%>">Hello <%=name%></h1>
        <p>We have forgotten your name and color. They are not stored in your cookies.</p>
    <%}%>
    <a href="preference">Return</a>

</body>
</html>
